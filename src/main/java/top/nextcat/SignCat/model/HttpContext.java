package top.nextcat.SignCat.model;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import top.nextcat.SignCat.helper.OkHttpHelper;

import java.util.List;
import java.util.Map;

public class HttpContext {
    private String url;
    private Headers headers;
    private String bodyMediaType;
    private JSONObject jsonBody;
    private String textBody;
    private CookieManager cookieJar = new CookieManager();
    private Map<String, Map<String, Cookie>> cookieMap;

    public HttpContext(String url, Headers headers, String bodyMediaType, JSONObject jsonBody, String textBody) {
        this.url = url;
        this.headers = headers;
        this.bodyMediaType = bodyMediaType;
        this.jsonBody = jsonBody;
        this.textBody = textBody;
    }

    public String getBody () {
        if (jsonBody != null) {
            return jsonBody.toString();
        } else if (textBody != null) {
            return textBody;
        } else {
            return "";
        }
    }

    public HttpContext() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBodyMediaType() {
        if (jsonBody != null) {
            return OkHttpHelper.HttpMediaType.JSON;
        } else if (textBody != null) {
            return OkHttpHelper.HttpMediaType.RAW;
        } else {
            return OkHttpHelper.HttpMediaType.RAW;
        }
    }

    public void setJsonBody(JSONObject jsonBody) {
        this.jsonBody = jsonBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public Headers getHeaders() {
        if (this.headers == null) {
            return new Headers.Builder().build();
        }
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public void setCookie(String cookie) {
        cookieJar.setCookie(this.getHttpUrl(),Cookie.parse(this.getHttpUrl(),cookie));
    }

    public void setCookies(List<String> cookies) {
        for (String cookie: cookies) {
            setCookie(cookie);
        }
    }

    public CookieManager getCookieJar() {
        return cookieJar;
    }

    public HttpUrl getHttpUrl() {
        return HttpUrl.parse(this.url);
    }

    public Map<String, Map<String, Cookie>> getCookieMap () {
//        this.cookieMap = this.cookieJar.getCOOKIE_MAP();
        return this.cookieMap;
    }

    public void setCookieMap(Map<String, Map<String, Cookie>> cookieMap) {
        this.cookieMap = cookieMap;
    }
}
