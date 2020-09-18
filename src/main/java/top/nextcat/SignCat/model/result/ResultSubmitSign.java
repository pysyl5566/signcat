package top.nextcat.SignCat.model.result;

public class ResultSubmitSign {
//    {
//        "code": "0",
//            "message": "SUCCESS",
//            "datas": {
//        "signInstanceWid": "23179",
//                "signedStuInfo": null
//    }
//    }
    public static class Data {
        private Integer signInstanceWid;
        private String signedStuInfo;

        public Data() {
        }

    public Data(Integer signInstanceWid, String signedStuInfo) {
        this.signInstanceWid = signInstanceWid;
        this.signedStuInfo = signedStuInfo;
    }

    public Integer getSignInstanceWid() {
        return signInstanceWid;
    }

    public void setSignInstanceWid(Integer signInstanceWid) {
        this.signInstanceWid = signInstanceWid;
    }

    public String getSignedStuInfo() {
        return signedStuInfo;
    }

    public void setSignedStuInfo(String signedStuInfo) {
        this.signedStuInfo = signedStuInfo;
    }
}

    private Long code;
    private String message;
    private Data datas;

    public ResultSubmitSign() {
    }

    public ResultSubmitSign(Long code, String message, Data datas) {
        this.code = code;
        this.message = message;
        this.datas = datas;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getDatas() {
        return datas;
    }

    public void setDatas(Data datas) {
        this.datas = datas;
    }
}
