package top.nextcat.SignCat.model;

import com.alibaba.fastjson.JSONObject;
import top.nextcat.SignCat.utils.EncryptHelper;
import top.nextcat.SignCat.utils.RandomGUIDUtils;

public class CpdailyInfo {
    private String systemName = "android";//系统名称，如：android
    private String systemVersion = "10.1.1";//系统版本，如：10.1.1
    private String model = "K20 Pro";//设备版本，如：MuMu、K20 Pro
    private String deviceId = new RandomGUIDUtils().toString();//设备ID，可以随机生成
    private String appVersion = "8.1.19";//APP版本，如：8.1.19
    //注意：登录的时候，经纬度均为0，且用户ID为空
    private double lon = 0.0;//经度
    private double lat = 0.0;//纬度
    private String userId = "";//用户ID

    public String toJSON() {
        return JSONObject.toJSONString(this);
    }

    public String encrypt() {
        return EncryptHelper.encrypt(JSONObject.toJSONString(this), "ST83=@XV");
    }

    public CpdailyInfo(String systemName, String systemVersion, String model, String deviceId, String appVersion, double lon, double lat, String userId) {
        this.systemName = systemName;
        this.systemVersion = systemVersion;
        this.model = model;
        this.deviceId = deviceId;
        this.appVersion = appVersion;
        this.lon = lon;
        this.lat = lat;
        this.userId = userId;
    }

    public CpdailyInfo() {

    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
