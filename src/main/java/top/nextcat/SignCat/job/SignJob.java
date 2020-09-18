package top.nextcat.SignCat.job;

import com.alibaba.fastjson.JSON;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import top.nextcat.SignCat.helper.*;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.model.result.Result;
import top.nextcat.SignCat.model.result.ResultSignInfo;
import top.nextcat.SignCat.model.result.ResultSignTask;
import top.nextcat.SignCat.service.CpdailyUserService;
import top.nextcat.SignCat.service.SignService;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class SignJob implements Job {
    @Resource
    SignService signService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(new Date());

        SignTask signTask = (SignTask) jobExecutionContext.getJobDetail().getJobDataMap().get("data");

        Result result = signService.autoSign(signTask);
        if (result.getErrCode() != 0) {
            System.out.println(result.getErrMsg());
        }

    }
}
