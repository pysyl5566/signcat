package top.nextcat.SignCat.serviceImpl;

import com.alibaba.fastjson.JSON;
import org.quartz.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import top.nextcat.SignCat.helper.*;
import top.nextcat.SignCat.job.SignJob;
import top.nextcat.SignCat.model.CpdailyInfo;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.model.result.Result;
import top.nextcat.SignCat.model.result.ResultSignInfo;
import top.nextcat.SignCat.model.result.ResultSignTask;
import top.nextcat.SignCat.model.result.ResultSubmitSign;
import top.nextcat.SignCat.service.CpdailyTaskService;
import top.nextcat.SignCat.service.QuartzService;
import top.nextcat.SignCat.service.SignService;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

@Service
public class SignServiceImpl implements SignService {
    @Resource
    CpdailyTaskService cpdailyTaskService;
    @Resource
    QuartzService quartzService;

    @Override
    public void addAutoSignJob(SignTask signTask) {
        System.out.println(signTask.getCron());
        if (cpdailyTaskService.insertSignTask(signTask)) {
            Date date = quartzService.addJob(SignJob.class,signTask.getCron(),signTask,signTask.getId().toString());

            if (date != null) {
                signTask.setStartDate(date);
                cpdailyTaskService.updateStartDateById(signTask);
            }
        }
    }

    @Override
    public Result autoSign(SignTask signTask) {
        Result result = new Result();

        String modAuthCas = AuthHelper.getModAuthCas(signTask.getSignUser());

        if ("".equals(modAuthCas)) {
            result.setErrCode(-4);
            result.setErrMsg("身份失效，请删除并重新添加用户！");
            return result;
        }

        ResultSignInfo resultSignInfo = SignHelper.getSignInfo(signTask.getSignUser(),modAuthCas);

        int i = 0;
        int err = 0;
        StringBuffer sb = new StringBuffer();
        for (ResultSignTask resultSignTask : resultSignInfo.getDatas().getUnSignedTasks()) {
            i++;
            if (TimeHelper.isNeedSign(resultSignTask.getRateSignDate(),resultSignTask.getRateTaskBeginTime(),resultSignTask.getCurrentTime())) {
                signTask.getSignInfo().setSignInstanceWid(resultSignTask.getSignInstanceWid());
                Result r = this.sign(signTask);

                if (r.getErrCode() != 0) {
                    err++;
                    sb.append(r.getErrMsg() + "\n");
                }
            }
        }

        if (err != 0) {
            result.setErrCode(-1);
            result.setErrMsg("完成签到 " + i + " 个，但有 " + err + " 个签到失败！\n签到失败原因：\n" + sb);
        } else {
            result.setErrCode(0);
        }

        return result;
    }

    @Override
    public Result sign(SignTask signTask) {
        Result result = new Result();
        String modAuthCas = AuthHelper.getModAuthCas(signTask.getSignUser());

        if ("".equals(modAuthCas)) {
            result.setErrCode(-1);
            result.setErrMsg("身份失效，请删除并重新添加用户！");
            return result;
        }

        CpdailyInfo cpdailyInfo = new CpdailyInfo();
        cpdailyInfo.setLon(signTask.getSignInfo().getLongitude());
        cpdailyInfo.setLat(signTask.getSignInfo().getLatitude());
        cpdailyInfo.setUserId(signTask.getSignUser().getStudentId());

        ResultSubmitSign resultSubmitSign = SignHelper.submitSign(signTask.getSignUser(),modAuthCas,cpdailyInfo,signTask.getSignInfo());
        if (resultSubmitSign.getCode() != 0) {
            result.setErrCode(-3);
            result.setErrMsg("签到失败，原因为：" + resultSubmitSign.getMessage());
            ServerChanHelper.sendMessage(TimeHelper.getCurrentTime() + signTask.getSignUser().getSchoolName() + " " + signTask.getSignUser().getName() + "，签到失败，" + "原因为：" + result.getErrMsg());
            return result;
        }
        ServerChanHelper.sendMessage(TimeHelper.getCurrentTime() + signTask.getSignUser().getSchoolName() + " " + signTask.getSignUser().getName() + "，签到成功！");
        result.setErrCode(0);
        return result;
    }
}
