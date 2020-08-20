package top.nextcat.SignCat.model.result;

public class ResultMobileMessageCode {
//    {
//        "errCode": 0,
//            "errMsg": null,
//            "data": {
//        "countdown": 60,
//                "tipMsg": "",
//                "status": 200
//    }
//    }
    public static class Data {
        private Integer countdown;
        private String tipMsg;
        private Integer status;

        public Data() {
        }

        public Data(Integer countdown, String tipMsg, Integer status) {
            this.countdown = countdown;
            this.tipMsg = tipMsg;
            this.status = status;
        }

        public Integer getCountdown() {
            return countdown;
        }

        public void setCountdown(Integer countdown) {
            this.countdown = countdown;
        }

        public String getTipMsg() {
            return tipMsg;
        }

        public void setTipMsg(String tipMsg) {
            this.tipMsg = tipMsg;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

    private Integer errCode;
    private String errMsg;
    private Data data;

    public ResultMobileMessageCode() {
    }

    public ResultMobileMessageCode(Integer errCode, String errMsg, Data data) {
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
