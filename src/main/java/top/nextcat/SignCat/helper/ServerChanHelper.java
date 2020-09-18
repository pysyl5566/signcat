package top.nextcat.SignCat.helper;

import com.alibaba.fastjson.JSONObject;
import top.nextcat.SignCat.api.AuthApi;
import top.nextcat.SignCat.api.BaseURL;
import top.nextcat.SignCat.api.ServerChanApi;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.HttpContext;
import top.nextcat.SignCat.model.result.ResultServerChan;

public class ServerChanHelper {
    private final static String serverChanKey = "SCU109804Tace5504b45afc9c7dad2daf24672b9c15f3b4907b7ddc";

    public static ResultServerChan sendMessage (String key, String message) {
        String apiUrl = BaseURL.BASE_URL_SERVER_CHAN + ServerChanApi.API_SEND_MESSAGE.replaceFirst("\\{SCKEY\\}",key) + "?text=" + message;
        HttpContext httpContext = new HttpContext();
        httpContext.setUrl(apiUrl);
        HttpContext responseHttpContext = OkHttpHelper.post(httpContext);

        if (!OkHttpHelper.HttpMediaType.JSON.equals(responseHttpContext.getBodyMediaType())) {
            return null;
        }
        return JSONObject.parseObject(responseHttpContext.getBody(), ResultServerChan.class);
    }

    public static ResultServerChan sendMessage (String message) {
        String apiUrl = BaseURL.BASE_URL_SERVER_CHAN + ServerChanApi.API_SEND_MESSAGE.replaceFirst("\\{SCKEY\\}",serverChanKey) + "?text=" + message;
        HttpContext httpContext = new HttpContext();
        httpContext.setUrl(apiUrl);
        HttpContext responseHttpContext = OkHttpHelper.post(httpContext);

        if (!OkHttpHelper.HttpMediaType.JSON.equals(responseHttpContext.getBodyMediaType())) {
            return null;
        }
        return JSONObject.parseObject(responseHttpContext.getBody(), ResultServerChan.class);
    }
}
