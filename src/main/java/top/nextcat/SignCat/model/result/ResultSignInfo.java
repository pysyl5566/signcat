package top.nextcat.SignCat.model.result;

import java.util.List;

public class ResultSignInfo {
//    {
//        "code": "0",
//            "message": "SUCCESS",
//            "datas": {
//        "dayInMonth": "2020-08-12",
//                "codeRcvdTasks": [],
//        "signedTasks": [],
//        "unSignedTasks": [{
//            "stuSignWid": "4807615",
//                    "signInstanceWid": "23255",
//                    "signWid": "102583",
//                    "signRate": "1",
//                    "taskType": "1",
//                    "taskName": "家里签到",
//                    "senderUserName": "计算机科学与信息工程学院(史红玉)",
//                    "signStatus": "2",
//                    "isMalposition": null,
//                    "isLeave": "0",
//                    "leavePcUrl": null,
//                    "leaveMobileUrl": null,
//                    "currentTime": "2020-08-12 09:53",
//                    "singleTaskBeginTime": null,
//                    "singleTaskEndTime": null,
//                    "rateSignDate": "2020-08-12 (周三)",
//                    "rateTaskBeginTime": "00:00",
//                    "rateTaskEndTime": "17:59"
//        }],
//        "leaveTasks": []
//    }
//    }
    public static class Data {
        private String dayInMonth;
        private List<ResultSignTask> codeRcvdTasks;
        private List<ResultSignTask> signedTasks;
        private List<ResultSignTask> unSignedTasks;
        private List<ResultSignTask> leaveTasks;

        public Data() {
        }

        public Data(String dayInMonth, List<ResultSignTask> codeRcvdTasks, List<ResultSignTask> signedTasks, List<ResultSignTask> unSignedTasks, List<ResultSignTask> leaveTasks) {
            this.dayInMonth = dayInMonth;
            this.codeRcvdTasks = codeRcvdTasks;
            this.signedTasks = signedTasks;
            this.unSignedTasks = unSignedTasks;
            this.leaveTasks = leaveTasks;
        }

        public String getDayInMonth() {
            return dayInMonth;
        }

        public void setDayInMonth(String dayInMonth) {
            this.dayInMonth = dayInMonth;
        }

        public List<ResultSignTask> getCodeRcvdTasks() {
            return codeRcvdTasks;
        }

        public void setCodeRcvdTasks(List<ResultSignTask> codeRcvdTasks) {
            this.codeRcvdTasks = codeRcvdTasks;
        }

        public List<ResultSignTask> getSignedTasks() {
            return signedTasks;
        }

        public void setSignedTasks(List<ResultSignTask> signedTasks) {
            this.signedTasks = signedTasks;
        }

        public List<ResultSignTask> getUnSignedTasks() {
            return unSignedTasks;
        }

        public void setUnSignedTasks(List<ResultSignTask> unSignedTasks) {
            this.unSignedTasks = unSignedTasks;
        }

        public List<ResultSignTask> getLeaveTasks() {
            return leaveTasks;
        }

        public void setLeaveTasks(List<ResultSignTask> leaveTasks) {
            this.leaveTasks = leaveTasks;
        }
}

    private Integer code;
    private String message;
    private Data datas;

    public ResultSignInfo() {
    }

    public ResultSignInfo(Integer code, String message, Data datas) {
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
