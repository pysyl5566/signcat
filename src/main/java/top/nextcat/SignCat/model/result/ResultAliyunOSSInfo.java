package top.nextcat.SignCat.model.result;

public class ResultAliyunOSSInfo {
//    {
//        "code": "0",
//            "datas": {
//        "accessKeyId": "STS.NT2YqqXFUcnZ1tCJkpJLKEU11",
//                "accessKeySecret": "YqHZQfH7eVFQFY33ZM2hWiwVwJ7UrfvqsHEcUtzidTq",
//                "securityToken": "CAIShAN1q6Ft5B2yfSjIr5eHEsvFtZl01KyxM1LyrmslRsNnqpCa0zz2IH1LfHZgAuEesPw1m2xT6/cTlr0qEsIVGxybMpcutsoGqFP5JtKZ4pRFSBOOXdv3d1KIAjvXgeUFCoeQFaEME5XAQlTAkTAJK9KYERypQ12iN7CQlJdjda55dwKkbD1AdtU0Qwx5s501OGf2P/SgOQKI523LFxhQpxZbg2Fy4rjdusqH8UjygVn31uIyrYb8KYTGCs53J8VbUsyp5OVsarGjoClL8Epj/qBskIlZ/SvGptiHH2RJ5xKPP4iz9cZ0fit4fbQdEaxJp+Tn774a3NbejIPq0R1AEPhIWiDEPuCazdDDBfmiO6ReF9PyMG+f1cuUZNun8VFmQwpCbV4aJYp+dSMuUUJ9E2GCEML9pgCWODXEYrOezaQ73aByy1jV5teQLzCNOe7Ejn5HasRtNx1wbUFKhjGwI7V1eghNYk5hAK2OUYJwYRZRpKXlpwTOUTd6yXVarykzhQceaE91GoABIOQ6vQW7a/L0lH+XRXNKGLfkBOwjSfD8koxembo9aHCFUDw2wGDBnlyKaG+AcOXoy/JcNTgnXSWFvefCldEUwRX3J0bUO/DHFkPFavexDVPyxROp7I6g6YUf7id0vhUOiaLxPxy8Dfu2FLmO2X+uKjYlklfAQQ4o0mp2k/jCLZU=",
//                "expiration": "2020-08-11T07:00:21Z",
//                "endPoint": "oss-cn-hangzhou.aliyuncs.com",
//                "bucket": "wecloud-res",
//                "fileName": "counselor/1018615936542285/content/6f15ace341a04414887ed9933cebcefc.png"
//    },
//        "message": "SUCCESS"
//    }
    public static class Data {
        private String accessKeyId;
        private String accessKeySecret;
        private String securityToken;
        private String expiration;
        private String endPoint;
        private String bucket;
        private String fileName;

        public Data() {
        }

        public Data(String accessKeyId, String accessKeySecret, String securityToken, String expiration, String endPoint, String bucket, String fileName) {
            this.accessKeyId = accessKeyId;
            this.accessKeySecret = accessKeySecret;
            this.securityToken = securityToken;
            this.expiration = expiration;
            this.endPoint = endPoint;
            this.bucket = bucket;
            this.fileName = fileName;
        }

        public String getAccessKeyId() {
            return accessKeyId;
        }

        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }

        public String getAccessKeySecret() {
            return accessKeySecret;
        }

        public void setAccessKeySecret(String accessKeySecret) {
            this.accessKeySecret = accessKeySecret;
        }

        public String getSecurityToken() {
            return securityToken;
        }

        public void setSecurityToken(String securityToken) {
            this.securityToken = securityToken;
        }

        public String getExpiration() {
            return expiration;
        }

        public void setExpiration(String expiration) {
            this.expiration = expiration;
        }

        public String getEndPoint() {
            return endPoint;
        }

        public void setEndPoint(String endPoint) {
            this.endPoint = endPoint;
        }

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }
    }

    private Integer code;
    private String message;
    private Data datas;

    public ResultAliyunOSSInfo() {
    }

    public ResultAliyunOSSInfo(Integer code, String message, Data datas) {
        this.code = code;
        this.message = message;
        this.datas = datas;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
