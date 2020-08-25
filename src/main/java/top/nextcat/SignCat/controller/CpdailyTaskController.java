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
import top.nextcat.SignCat.model.SignInfo;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.model.result.Result;
import top.nextcat.SignCat.model.result.ResultLoginInfo;
import top.nextcat.SignCat.model.result.ResultMobileMessageCode;
import top.nextcat.SignCat.pojo.DataTables;
import top.nextcat.SignCat.service.CpdailyTaskService;
import top.nextcat.SignCat.service.CpdailyUserService;
import top.nextcat.SignCat.service.SignInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CpdailyTaskController {
    @Resource
    CpdailyTaskService cpdailyTaskService;
    @Resource
    SignInfoService signInfoService;

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

        SignInfo signInfo = signTask.getSignInfo();

        if (!signInfoService.save(signTask.getSignInfo())) {
            result.setErrCode(-2);
            result.setErrMsg("新增今日校园账号失败！");
            return result;
        }

        signTask.setSignInfo(signInfo);

        System.out.println(JSONObject.toJSONString(signTask));

        if (!cpdailyTaskService.insertSignTask(signTask)) {
            signInfoService.removeById(signInfo.getId());
            result.setErrCode(-2);
            result.setErrMsg("新增今日校园账号失败！");
            return result;
        }

        result.setErrCode(0);
        return result;
    }
}
