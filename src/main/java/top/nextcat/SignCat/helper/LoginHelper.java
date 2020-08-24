package top.nextcat.SignCat.helper;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Headers;
import top.nextcat.SignCat.api.BaseURL;
import top.nextcat.SignCat.api.LoginApi;
import top.nextcat.SignCat.model.CpdailyInfo;
import top.nextcat.SignCat.model.HttpContext;
import top.nextcat.SignCat.model.result.ResultLoginInfo;
import top.nextcat.SignCat.model.result.ResultMobileMessageCode;
import top.nextcat.SignCat.utils.EncryptHelper;

public class LoginHelper {
    public static ResultMobileMessageCode sendMobileMessageCode (String phoneNumber) {
        CpdailyInfo cpdailyInfo = new CpdailyInfo();
        JSONObject body = new JSONObject();
        body.put("mobile", EncryptHelper.encrypt(phoneNumber, "ST83=@XV"));
        HttpContext httpContext = new HttpContext();
        httpContext.setUrl(BaseURL.BASE_URL_MOBILE_CAMPUSHOY + LoginApi.API_SEND_MOBILE_MESSAGE_CODE);
        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder.add("CpdailyInfo",cpdailyInfo.encrypt());
        httpContext.setHeaders(headersBuilder.build());
        httpContext.setJsonBody(body);
        HttpContext responseHttpContext = OkHttpHelper.post(httpContext);

        if (!responseHttpContext.getBodyMediaType().equals(OkHttpHelper.HttpMediaType.JSON)) {
            ResultMobileMessageCode resultMobileMessageCode = new ResultMobileMessageCode();
            resultMobileMessageCode.setErrCode(-1);
            resultMobileMessageCode.setErrMsg("获取验证码失败，该错误为系统错误（无法正常使用签到API），请务必联系本站管理员！");
            return null;
        }

        return JSONObject.parseObject(responseHttpContext.getBody(), ResultMobileMessageCode.class);
    }

    public static ResultLoginInfo mobileLogin (String phoneNumber, String messageCode) {
        CpdailyInfo cpdailyInfo = new CpdailyInfo();
        JSONObject body = new JSONObject();
        body.put("loginId",phoneNumber);
        body.put("loginToken",messageCode);
        HttpContext httpContext = new HttpContext();
        httpContext.setUrl(BaseURL.BASE_URL_MOBILE_CAMPUSHOY + LoginApi.API_MOBILE_LOGIN);
        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder.add("CpdailyInfo",cpdailyInfo.encrypt());
        httpContext.setHeaders(headersBuilder.build());
        httpContext.setJsonBody(body);
        HttpContext responseHttpContext = OkHttpHelper.post(httpContext);

        if (!responseHttpContext.getBodyMediaType().equals(OkHttpHelper.HttpMediaType.JSON)) {
            ResultLoginInfo resultLoginInfo = new ResultLoginInfo();
            resultLoginInfo.setErrCode(-1);
            resultLoginInfo.setErrMsg("获取验证码失败，该错误为系统错误（无法正常使用签到API），请务必联系本站管理员！");
            return null;
        }

        return JSONObject.parseObject(responseHttpContext.getBody(), ResultLoginInfo.class);
    }
}
