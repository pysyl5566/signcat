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
import top.nextcat.SignCat.model.result.ResultMobileMessageCode;
import top.nextcat.SignCat.pojo.DataTables;
import top.nextcat.SignCat.service.CpdailyUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CpdailyController {
    @Resource
    CpdailyUserService cpdailyUserService;

    @RequestMapping(method = RequestMethod.POST,value = "/v1/cpdaily/mobile/sendCode")
    @ResponseBody
    public ResultMobileMessageCode cpdailySendMobileCode (HttpServletRequest request,@RequestBody String requestParam) {
        JSONObject jsonObject = JSON.parseObject(requestParam);

//        DataTables dataTables = new DataTables();
//        List<CpdailyUser> cpdailyUsers = cpdailyUserService.list();
//
//        if (cpdailyUsers != null) {
//            dataTables.setCode(0);
//            dataTables.setCount(cpdailyUsers.size());
//            dataTables.setData(cpdailyUsers);
//            dataTables.setMsg("获取所有今日校园用户成功。");
//        }
        return LoginHelper.sendMobileMessageCode(jsonObject.getString("mobile"));
    }
}
