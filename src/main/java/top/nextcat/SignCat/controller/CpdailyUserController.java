package top.nextcat.SignCat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.nextcat.SignCat.helper.LoginHelper;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.result.Result;
import top.nextcat.SignCat.model.result.ResultLoginInfo;
import top.nextcat.SignCat.pojo.DataTables;
import top.nextcat.SignCat.service.CpdailyUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CpdailyUserController {
    @Resource
    CpdailyUserService cpdailyUserService;

    @RequestMapping(method = RequestMethod.GET,value = "/v1/cpdaily/user/list")
    @ResponseBody
    public DataTables cpdailyUserList (HttpServletRequest request) {
        DataTables dataTables = new DataTables();
        List<CpdailyUser> cpdailyUsers = cpdailyUserService.list();

        if (cpdailyUsers != null) {
            dataTables.setCode(0);
            dataTables.setCount(cpdailyUsers.size());
            dataTables.setData(cpdailyUsers);
            dataTables.setMsg("获取所有今日校园用户成功。");
        }
        return dataTables;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/v1/cpdaily/user/add")
    @ResponseBody
    public Result cpdailyUserAdd (HttpServletRequest request, @RequestBody String requestParam) {
        Result result = new Result();
        JSONObject jsonObject = JSON.parseObject(requestParam);

        System.out.println(jsonObject.getString("mobile"));
        System.out.println(jsonObject.getString("mobileCode"));
        ResultLoginInfo resultLoginInfo =  LoginHelper.mobileLogin(jsonObject.getString("mobile"),jsonObject.getString("mobileCode"));

        if (resultLoginInfo.getErrCode() != 0) {
            result.setErrCode(resultLoginInfo.getErrCode());
            result.setErrMsg(resultLoginInfo.getErrMsg());
            return result;
        }

        CpdailyUser cpdailyUser = new CpdailyUser();
        cpdailyUser.setMobile(jsonObject.getString("mobile"));
        cpdailyUser.setSchoolCode(resultLoginInfo.getData().getTenantId());
        cpdailyUser.setStudentId(resultLoginInfo.getData().getOpenId());
        cpdailyUser.setName(resultLoginInfo.getData().getName());
        System.out.println("TGC:" + resultLoginInfo.getData().getTgc());
        cpdailyUser.setTgc(resultLoginInfo.getData().getTgc());
        cpdailyUser.setSessionToken(resultLoginInfo.getData().getSessionToken());
        if (!cpdailyUserService.save(cpdailyUser)) {
            result.setErrCode(-2);
            result.setErrMsg("新增今日校园账号失败！");
            return result;
        }
        result.setErrCode(0);
        return result;
    }
}
