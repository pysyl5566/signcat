package top.nextcat.SignCat.model.result;

public class ResultLoginInfo {
//    {
//        "errCode": 2005,
//            "errMsg": "验证码错误次数上限5次,您已输错1次",
//            "data": {
//        "personId": "",
//                "userId": "",
//                "authId": "",
//                "openId": "",
//                "name": "",
//                "tenantId": "",
//                "mobile": "",
//                "userType": "STUDENT",
//                "status": "",
//                "authStatus": "",
//                "deviceStatus": "noexception",
//                "deviceExceptionMsg": "",
//                "tgcStatus": "",
//                "tgc": "",
//                "sessionToken": "",
//                "firstLogin": false
//    }
//    }
        public static class Data {
            private String userId;
            private String authId;
            private String openId;
            private String name;
            private String tenantId;
            private String mobile;
            private String userType;
            private String status;
            private String authStatus;
            private String deviceStatus;
            private String deviceExceptionMsg;
            private String tgcStatus;
            private String tgc;
            private String sessionToken;
            private boolean firstLogin;

        public Data() {
        }

        public Data(String userId, String authId, String openId, String name, String tenantId, String mobile, String userType, String status, String authStatus, String deviceStatus, String deviceExceptionMsg, String tgcStatus, String tgc, String sessionToken, boolean firstLogin) {
            this.userId = userId;
            this.authId = authId;
            this.openId = openId;
            this.name = name;
            this.tenantId = tenantId;
            this.mobile = mobile;
            this.userType = userType;
            this.status = status;
            this.authStatus = authStatus;
            this.deviceStatus = deviceStatus;
            this.deviceExceptionMsg = deviceExceptionMsg;
            this.tgcStatus = tgcStatus;
            this.tgc = tgc;
            this.sessionToken = sessionToken;
            this.firstLogin = firstLogin;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getAuthId() {
            return authId;
        }

        public void setAuthId(String authId) {
            this.authId = authId;
        }

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTenantId() {
            return tenantId;
        }

        public void setTenantId(String tenantId) {
            this.tenantId = tenantId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAuthStatus() {
            return authStatus;
        }

        public void setAuthStatus(String authStatus) {
            this.authStatus = authStatus;
        }

        public String getDeviceStatus() {
            return deviceStatus;
        }

        public void setDeviceStatus(String deviceStatus) {
            this.deviceStatus = deviceStatus;
        }

        public String getDeviceExceptionMsg() {
            return deviceExceptionMsg;
        }

        public void setDeviceExceptionMsg(String deviceExceptionMsg) {
            this.deviceExceptionMsg = deviceExceptionMsg;
        }

        public String getTgcStatus() {
            return tgcStatus;
        }

        public void setTgcStatus(String tgcStatus) {
            this.tgcStatus = tgcStatus;
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

        public boolean isFirstLogin() {
            return firstLogin;
        }

        public void setFirstLogin(boolean firstLogin) {
            this.firstLogin = firstLogin;
        }
}

    private Integer errCode;
    private String errMsg;
    private Data data;

    public ResultLoginInfo() {
    }

    public ResultLoginInfo(Integer errCode, String errMsg, Data data) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.data = data;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
