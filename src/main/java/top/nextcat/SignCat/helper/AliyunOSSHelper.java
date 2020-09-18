package top.nextcat.SignCat.helper;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Headers;
import top.nextcat.SignCat.aliyun.OSSConfig;
import top.nextcat.SignCat.aliyun.OSSHelper;
import top.nextcat.SignCat.api.AliyunOSSApi;
import top.nextcat.SignCat.api.AuthApi;
import top.nextcat.SignCat.api.BaseURL;
import top.nextcat.SignCat.api.SignApi;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.HttpContext;
import top.nextcat.SignCat.model.UploadFile;
import top.nextcat.SignCat.model.result.ResultAliyunOSSInfo;
import top.nextcat.SignCat.model.result.ResultAuthSchoolInfo;

public class AliyunOSSHelper {
    public static ResultAliyunOSSInfo getAliyunOSSInfo (CpdailyUser cpdailyUser, String modAuthCas) {
        ResultAuthSchoolInfo resultAuthSchoolInfo = AuthHelper.getSchoolAuthInfo(cpdailyUser);
        if (resultAuthSchoolInfo == null) {
            return null;
        }

        String protocol = StringHelper.getSubString(resultAuthSchoolInfo.getData().get(0).getAmpUrl(),"","://");
        String schoolUrl = StringHelper.getSubString(resultAuthSchoolInfo.getData().get(0).getAmpUrl(),"://","/");
        String apiUrl = protocol + "://" + schoolUrl + AliyunOSSApi.API_GET_ALIYUN_OSS;

        HttpContext httpContext = new HttpContext();
        httpContext.setUrl(apiUrl);
        Headers.Builder headersBuilder = new Headers.Builder();
        headersBuilder.add("Cookie","MOD_AUTH_CAS=" + modAuthCas + ";");
        httpContext.setHeaders(headersBuilder.build());
        httpContext.setJsonBody(new JSONObject());
        HttpContext responseHttpContext = OkHttpHelper.post(httpContext);

        if (!responseHttpContext.getBodyMediaType().equals(OkHttpHelper.HttpMediaType.JSON)) {
            return null;
        }

        return JSONObject.parseObject(responseHttpContext.getBody(), ResultAliyunOSSInfo.class);
    }

    public static boolean uploadFile (OSSConfig ossConfig, UploadFile uploadFile) {
        return OSSHelper.uploadFile(ossConfig, uploadFile);
//        HttpContext httpContext = new HttpContext();
//        httpContext.setUrl(BaseURL.BASE_URL_SCHOOL_CAMPUSHOY.replaceFirst("\\{schoolCode\\}",schoolCode) + AliyunOSSApi.API_GET_ALIYUN_OSS);
//        Headers.Builder headersBuilder = new Headers.Builder();
//        headersBuilder.add("Cookie","MOD_AUTH_CAS=" + modAuthCas + ";");
//        httpContext.setHeaders(headersBuilder.build());
//        httpContext.setJsonBody(new JSONObject());
//        OkHttpHelper.post(httpContext);
//        postBody.setHeaders(headers);
//        postBody.setBody(body);
//        DailyCampusHelper.postJSON(LoginApi.API_SEND_MOBILE_MESSAGE_CODE,postBody);
//        System.out.println(AuthApi.API_GET_MOD_AUTH_CAS.replaceFirst("\\{schoolCode\\}",schoolCode));
//        DailyCampusHelper.postJSONByCampushoy(AuthApi.API_GET_MOD_AUTH_CAS.replaceFirst("\\{schoolCode\\}",schoolCode),postBody);

    }
}
