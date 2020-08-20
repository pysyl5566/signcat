package top.nextcat.SignCat.model;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CookieManager implements CookieJar {
    private final Map<String, Map<String,Cookie>> COOKIE_MAP = new HashMap<String, Map<String, Cookie>>();

    @NotNull
    public List<Cookie> loadForRequest(@NotNull HttpUrl httpUrl) {
        Map<String, Cookie> cookieMap = this.COOKIE_MAP.get(httpUrl.host());
        if (cookieMap == null) {
            return Collections.emptyList();
        }
        return new ArrayList<Cookie>(cookieMap.values());
    }

    public void saveFromResponse(@NotNull HttpUrl httpUrl, @NotNull List<Cookie> cookies) {
        setCookies(httpUrl, cookies);
    }

    public void setCookie (HttpUrl httpUrl,Cookie cookie) {
        List<Cookie> cookies = new ArrayList<Cookie>();
        cookies.add(cookie);
        setCookies(httpUrl,cookies);
    }

    public void setCookies (HttpUrl httpUrl,List<Cookie> cookies) {
        String host = httpUrl.host();
        Map<String, Cookie> cookieMap = this.COOKIE_MAP.get(host);
        if (cookieMap == null) {
            cookieMap = new HashMap<String, Cookie>();
        }
        // 便于新 cookie 替换老的 cookie
        for (Cookie cookie : cookies) {
            cookieMap.put(cookie.name(), cookie);
        }
        this.COOKIE_MAP.put(host, cookieMap);
    }

    public Map<String, Map<String, Cookie>> getCOOKIE_MAP() {
        return this.COOKIE_MAP;
    }
}
