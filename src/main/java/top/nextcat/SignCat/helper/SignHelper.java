package top.nextcat.SignCat.helper;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Headers;
import top.nextcat.SignCat.api.BaseURL;
import top.nextcat.SignCat.api.SignApi;
import top.nextcat.SignCat.model.CpdailyInfo;
import top.nextcat.SignCat.model.HttpContext;
import top.nextcat.SignCat.model.SignInfo;
import top.nextcat.SignCat.model.result.ResultSignInfo;
import top.nextcat.SignCat.model.result.ResultSubmitSign;

public class SignHelper {
    public static ResultSubmitSign submitSign (String schoolCode, String modAuthCas, CpdailyInfo cpdailyInfo, SignInfo signInfo) {
        String apiUrl = BaseURL.BASE_URL_SCHOOL_CAMPUSHOY.replaceFirst("\\{schoolCode\\}",schoolCode) + SignApi.API_SUBMIT_SIGN;
        HttpContext httpContext = new HttpContext();
        httpContext.setUrl(apiUrl);
        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder.add("Cpdaily-Extension",cpdailyInfo.encrypt());
        httpContext.setHeaders(headersBuilder.build());
        httpContext.setCookie("MOD_AUTH_CAS=" + modAuthCas + ";");
        JSONObject body = new JSONObject();
        body.put("signInstanceWid",signInfo.getSignInstanceWid());
        body.put("longitude",signInfo.getLongitude());
        body.put("latitude",signInfo.getLatitude());
        body.put("isMalposition",signInfo.getIsMalposition());
        body.put("abnormalReason",signInfo.getAbnormalReason());
        body.put("signPhotoUrl",signInfo.getSignPhotoUrl());
        body.put("position",signInfo.getPosition());
        body.put("isNeedExtra",signInfo.getIsNeedExtra());
        httpContext.setJsonBody(body);
        HttpContext responseHttpContext = OkHttpHelper.post(httpContext);

        if (!responseHttpContext.getBodyMediaType().equals(OkHttpHelper.HttpMediaType.JSON)) {
            return null;
        }

        return JSONObject.parseObject(responseHttpContext.getBody(), ResultSubmitSign.class);
    }

    public static ResultSignInfo getSignInfo (String schoolCode, String modAuthCas) {
        String apiUrl = BaseURL.BASE_URL_SCHOOL_CAMPUSHOY.replaceFirst("\\{schoolCode\\}",schoolCode) + SignApi.API_GET_SIGN_INFO;
        HttpContext httpContext = new HttpContext();
        httpContext.setUrl(apiUrl);
        httpContext.setCookie("MOD_AUTH_CAS=" + modAuthCas + ";");
        httpContext.setJsonBody(new JSONObject());
        HttpContext responseHttpContext = OkHttpHelper.post(httpContext);

        if (responseHttpContext.getBodyMediaType() != OkHttpHelper.HttpMediaType.JSON) {
            return null;
        }

        return JSONObject.parseObject(responseHttpContext.getBody(), ResultSignInfo.class);
    }
}
