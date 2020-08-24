package top.nextcat.SignCat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.nextcat.SignCat.helper.LoginHelper;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.model.result.Result;
import top.nextcat.SignCat.model.result.ResultLoginInfo;
import top.nextcat.SignCat.model.result.ResultMobileMessageCode;
import top.nextcat.SignCat.pojo.DataTables;
import top.nextcat.SignCat.service.CpdailyTaskService;
import top.nextcat.SignCat.service.CpdailyUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CpdailyTaskController {
    @Resource
    CpdailyTaskService cpdailyTaskService;

    @RequestMapping(method = RequestMethod.GET,value = "/v1/cpdaily/task/list")
    @ResponseBody
    public DataTables cpdailyTaskList (HttpServletRequest request) {
        DataTables dataTables = new DataTables();
        List<SignTask> signTasks = cpdailyTaskService.all();

        if (signTasks != null) {
            dataTables.setCode(0);
            dataTables.setCount(signTasks.size());
            dataTables.setData(signTasks);
            dataTables.setMsg("获取所有今日校园签到任务成功。");
        }
        return dataTables;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/v1/cpdaily/task/add")
    @ResponseBody
    public Result cpdailyTaskAdd (HttpServletRequest request, @RequestBody SignTask signTask) {
        Result result = new Result();
        if (cpdailyTaskService.save(signTask)) {
            result.setErrCode(-2);
            result.setErrMsg("新增今日校园账号失败！");
            return result;
        }

        result.setErrCode(0);
        return result;

//        JSONObject jsonObject = JSON.parseObject(requestParam);

//        System.out.println(jsonObject.getString("mobile"));
//        System.out.println(jsonObject.getString("mobileCode"));
//        ResultLoginInfo resultLoginInfo =  LoginHelper.mobileLogin(jsonObject.getString("mobile"),jsonObject.getString("mobileCode"));

//        if (resultLoginInfo.getErrCode() != 0) {
//            result.setErrCode(resultLoginInfo.getErrCode());
//            result.setErrMsg(resultLoginInfo.getErrMsg());
//            return result;
//        }
//
//        CpdailyUser cpdailyUser = new CpdailyUser();
//        cpdailyUser.setMobile(jsonObject.getString("mobile"));
//        cpdailyUser.setSchoolCode(resultLoginInfo.getData().getTenantId());
//        cpdailyUser.setStudentId(resultLoginInfo.getData().getOpenId());
//        cpdailyUser.setName(resultLoginInfo.getData().getName());
//        System.out.println("TGC:" + resultLoginInfo.getData().getTgc());
//        cpdailyUser.setTgc(resultLoginInfo.getData().getTgc());
//        cpdailyUser.setSessionToken(resultLoginInfo.getData().getSessionToken());
//        if (!cpdailyUserService.save(cpdailyUser)) {
//            result.setErrCode(-2);
//            result.setErrMsg("新增今日校园账号失败！");
//            return result;
//        }
    }
}
