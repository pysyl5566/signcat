package top.nextcat.SignCat.model;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Headers;
import top.nextcat.SignCat.helper.OkHttpHelper;

import java.util.HashMap;

public class POSTBody {
    private HashMap<String,String> headers;
    private JSONObject body;

    public POSTBody(JSONObject body, HashMap<String, String> headers) {
        this.body = body;
        this.headers = headers;
    }

    public POSTBody() {
    }

    public JSONObject getBody() {
        return body;
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }

    public Headers getHeaders() {
        return OkHttpHelper.toHeaders(headers);
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }
}
