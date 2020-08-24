package top.nextcat.SignCat.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

@TableName("cpdaily_user")
public class CpdailyUser {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("mobile")
    private String mobile;
    @TableField("name")
    private String name;
    @TableField("school_code")
    private String schoolCode;
    @TableField("student_id")
    private String studentId;
    @JsonIgnore
    @TableField("tgc")
    private String tgc;
    @JsonIgnore
    @TableField("session_token")
    private String sessionToken;

    public CpdailyUser() {
    }

    public CpdailyUser(Integer id, String mobile, String name, String schoolCode, String studentId, String tgc, String sessionToken) {
        this.id = id;
        this.mobile = mobile;
        this.name = name;
        this.schoolCode = schoolCode;
        this.studentId = studentId;
        this.tgc = tgc;
        this.sessionToken = sessionToken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTgc() {
        return tgc;
    }

    public void setTgc(String tgc) {
        this.tgc = tgc;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
