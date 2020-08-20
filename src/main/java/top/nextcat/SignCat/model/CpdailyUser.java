package top.nextcat.SignCat.model;

public class CpdailyUser {
    private String mobile;
    private String name;
    private String schoolCode;
    private String studentId;
    private String tgc;
    private String sessionToken;
    private String modAuthCas;

    public CpdailyUser() {
    }

    public CpdailyUser(String mobile, String name, String schoolCode, String studentId, String tgc, String sessionToken, String modAuthCas) {
        this.mobile = mobile;
        this.name = name;
        this.schoolCode = schoolCode;
        this.studentId = studentId;
        this.tgc = tgc;
        this.sessionToken = sessionToken;
        this.modAuthCas = modAuthCas;
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

    public String getModAuthCas() {
        return modAuthCas;
    }

    public void setModAuthCas(String modAuthCas) {
        this.modAuthCas = modAuthCas;
    }
}
