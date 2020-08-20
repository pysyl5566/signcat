package top.nextcat.SignCat.helper;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import top.nextcat.SignCat.model.HttpContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OkHttpHelper {
    public static class RequestMethod {
        public static int GET = 0;
        public static int POST = 1;
    }

    public static class HttpMediaType {
        public static String JSON = "application/json;charset=UTF-8";
        public static String RAW = "text/plain;charset=UTF-8";
        public static String HTML = "text/html;charset=UTF-8";
    }

    public static HttpContext post (HttpContext httpContext) {
        return request(RequestMethod.POST, httpContext);
    }

    public static HttpContext get (HttpContext httpContext) {
        return request(RequestMethod.GET, httpContext);
    }

    public static HttpContext request (final int requestMethod, final HttpContext requestHttpContext) {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        okHttpClientBuilder.addNetworkInterceptor(new Interceptor() {
            @NotNull
            public Response intercept(@NotNull Chain chain) throws IOException {
//                System.out.println(chain.request().url());
//                System.out.println(chain.request().headers().toString());
                System.out.println("[request]" + chain.request().headers().toString());
                Response response = chain.proceed(chain.request());
                System.out.println("[response]" + response.request().url());
                System.out.println(response.headers().toString());
                return response;
            }
        });

        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url(requestHttpContext.getUrl());
        requestBuilder.headers(requestHttpContext.getHeaders());
        okHttpClientBuilder.cookieJar(requestHttpContext.getCookieJar());

        if (requestMethod == RequestMethod.GET) {
            requestBuilder.get();
        } else if (requestMethod == RequestMethod.POST) {
            RequestBody requestBody = requestBody = RequestBody.create(requestHttpContext.getBody(), MediaType.parse(requestHttpContext.getBodyMediaType()));
            requestBuilder.post(requestBody);
        } else {
            return null;
        }

        Request request = requestBuilder.build();

        OkHttpClient client = okHttpClientBuilder.build();

        Call call = client.newCall(request);
        HttpContext responseHttpContext = new HttpContext();
        try {
            Response response = call.execute();
            Headers headers = response.headers();
            ResponseBody responseBody = response.body();
            if (responseBody == null) {
                return responseHttpContext;
            }
//            if (responseBody != null) {
//                responseHttpContext = new HttpContext();
//            } else {
//                return new HttpContext();
//            }

            responseHttpContext.setUrl(response.request().url().toString());
            responseHttpContext.setHeaders(headers);
            responseHttpContext.setCookieMap(requestHttpContext.getCookieJar().getCOOKIE_MAP());

            String responeMediaType = headers.get("Content-Type");
            if (responeMediaType.equals(HttpMediaType.JSON)) {
                responseHttpContext.setJsonBody(JSONObject.parseObject(responseBody.string()));
            } else if (responeMediaType.equals(HttpMediaType.RAW) || responeMediaType.equals(HttpMediaType.HTML)) {
                responseHttpContext.setTextBody(responseBody.string());
            } else {
                responseHttpContext.setTextBody(responseBody.string());
            }

            System.out.println(responseHttpContext.getBody());

//            System.out.println(response.request().url());
//            System.out.println(response.body().string());
//            System.out.println(response.headers().toString());
//            Map<String, Map<String, Cookie>> cookieMap = hostCookieJar.getCookieMap();
//            for (Map.Entry<String, Map<String, Cookie>> stringMapEntry: cookieMap.entrySet()) {
//                System.out.println("host:" + stringMapEntry.getKey());
//                for (Map.Entry<String, Cookie> cookie:stringMapEntry.getValue().entrySet()) {
//                    System.out.println("name:" + cookie.getKey() + "vaule:" + cookie.getValue());
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseHttpContext;
    }

    public static Headers toHeaders (HashMap<String, String> headers) {
        Headers.Builder headersbuilder = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> hashMap:headers.entrySet()) {
                headersbuilder.add(hashMap.getKey(),hashMap.getValue());
            }
        }
        return headersbuilder.build();
    }
}
