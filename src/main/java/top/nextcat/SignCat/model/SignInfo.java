package top.nextcat.SignCat.model;

public class SignInfo {
    private Integer signInstanceWid;//签到任务ID
    private double longitude;//经度
    private double latitude;//纬度
    private Integer isMalposition = 1;//是否超出范围0.否1.是
    private String abnormalReason;//范围外签到原因（体温等上报信息）
    private String signPhotoUrl;//签到照片
    private String position;//签到位置
    private Integer isNeedExtra = 0;//0

    public SignInfo() {
    }

    public SignInfo(Integer signInstanceWid, double longitude, double latitude, Integer isMalposition, String abnormalReason, String signPhotoUrl, String position, Integer isNeedExtra) {
        this.signInstanceWid = signInstanceWid;
        this.longitude = longitude;
        this.latitude = latitude;
        this.isMalposition = isMalposition;
        this.abnormalReason = abnormalReason;
        this.signPhotoUrl = signPhotoUrl;
        this.position = position;
        this.isNeedExtra = isNeedExtra;
    }

    public Integer getSignInstanceWid() {
        return signInstanceWid;
    }

    public void setSignInstanceWid(Integer signInstanceWid) {
        this.signInstanceWid = signInstanceWid;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Integer getIsMalposition() {
        return isMalposition;
    }

    public void setIsMalposition(Integer isMalposition) {
        this.isMalposition = isMalposition;
    }

    public String getAbnormalReason() {
        return abnormalReason;
    }

    public void setAbnormalReason(String abnormalReason) {
        this.abnormalReason = abnormalReason;
    }

    public String getSignPhotoUrl() {
        return signPhotoUrl;
    }

    public void setSignPhotoUrl(String signPhotoUrl) {
        this.signPhotoUrl = signPhotoUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getIsNeedExtra() {
        return isNeedExtra;
    }

    public void setIsNeedExtra(Integer isNeedExtra) {
        this.isNeedExtra = isNeedExtra;
    }
}
