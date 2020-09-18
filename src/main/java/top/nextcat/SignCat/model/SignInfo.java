package top.nextcat.SignCat.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

@TableName("sign_info")
public class SignInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @JsonIgnore
    @TableField(exist = false)
    private Integer signInstanceWid;//签到任务ID
    @TableField("longitude")
    private double longitude;//经度
    @TableField("latitude")
    private double latitude;//纬度
    @TableField("isMalposition")
    private Integer isMalposition = 1;//是否超出范围0.否1.是
    @TableField("abnormal_reason")
    private String abnormalReason;//范围外签到原因（体温等上报信息）
    @TableField("sign_photo_url")
    private String signPhotoUrl;//签到照片
    @TableField("position")
    private String position;//签到位置
    @TableField("isNeedExtra")
    private Integer isNeedExtra = 0;//0

    public SignInfo() {
    }

    public SignInfo(Integer id, Integer signInstanceWid, double longitude, double latitude, Integer isMalposition, String abnormalReason, String signPhotoUrl, String position, Integer isNeedExtra) {
        this.id = id;
        this.signInstanceWid = signInstanceWid;
        this.longitude = longitude;
        this.latitude = latitude;
        this.isMalposition = isMalposition;
        this.abnormalReason = abnormalReason;
        this.signPhotoUrl = signPhotoUrl;
        this.position = position;
        this.isNeedExtra = isNeedExtra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
