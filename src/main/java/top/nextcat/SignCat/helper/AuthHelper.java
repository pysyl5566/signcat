package top.nextcat.SignCat.helper;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import top.nextcat.SignCat.api.AuthApi;
import top.nextcat.SignCat.api.BaseURL;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.HttpContext;
import top.nextcat.SignCat.model.POSTBody;
import top.nextcat.SignCat.model.result.ResultLoginInfo;
import top.nextcat.SignCat.utils.EncryptHelper;

import java.util.Map;

public class AuthHelper {
    public static String getModeAuthCas (CpdailyUser cpdailyUser) {
        String apiUrl = BaseURL.BASE_URL_SCHOOL_CAMPUSHOY.replaceFirst("\\{schoolCode\\}",cpdailyUser.getSchoolCode()) + AuthApi.API_GET_MOD_AUTH_CAS;
        HttpContext httpContext = new HttpContext();
        httpContext.setUrl(apiUrl);
        httpContext.setCookie("CASTGC=" + cpdailyUser.getTgc() + ";");
        HttpContext responseHttpContext = OkHttpHelper.get(httpContext);

        if (responseHttpContext.getCookieMap().get(HttpUrl.parse(apiUrl).host()) != null) {
            for (Map.Entry<String, Cookie> cookie: responseHttpContext.getCookieMap().get(HttpUrl.parse(apiUrl).host()).entrySet()) {
                if ("MOD_AUTH_CAS".equals(cookie.getKey())) {
                    return cookie.getValue().value();
//                    cpdailyUser.setModAuthCas(cookie.getValue().value());
                }
            }
        }
        return "";
    }

    public static ResultLoginInfo newValidation (CpdailyUser cpdailyUser) {
        JSONObject body = new JSONObject();
        body.put("tgc", EncryptHelper.encrypt(cpdailyUser.getTgc(),"XCE927=="));
        POSTBody postBody = new POSTBody();
        HttpContext httpContext = new HttpContext();
        httpContext.setUrl(BaseURL.BASE_URL_MOBILE_CAMPUSHOY + AuthApi.API_NEW_VALIDATION);
        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder.add("Cookie","sessionToken=" + cpdailyUser.getSessionToken() + ";");
        httpContext.setHeaders(headersBuilder.build());
        httpContext.setJsonBody(body);
        HttpContext responseHttpContext = OkHttpHelper.post(httpContext);

        if (!responseHttpContext.getBodyMediaType().equals(OkHttpHelper.HttpMediaType.JSON)) {
            return null;
        }

        return JSONObject.parseObject(responseHttpContext.getBody(), ResultLoginInfo.class);
    }
}
