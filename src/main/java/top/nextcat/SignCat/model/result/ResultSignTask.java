package top.nextcat.SignCat.model.result;

public class ResultSignTask {
    private Integer stuSignWid;
    private Integer signInstanceWid;
    private Integer signWid;
    private Integer signRate;
    private Integer taskType;
    private String taskName;
    private String senderUserName;
    private Integer signStatus;
    private Integer isMalposition;
    private Integer isLeave;
    private String leavePcUrl;
    private String leaveMobileUrl;
    private String currentTime;
    private String singleTaskBeginTime;
    private String singleTaskEndTime;
    private String rateSignDate;
    private String rateTaskBeginTime;
    private String rateTaskEndTime;

    public ResultSignTask() {
    }

    public ResultSignTask(Integer stuSignWid, Integer signInstanceWid, Integer signWid, Integer signRate, Integer taskType, String taskName, String senderUserName, Integer signStatus, Integer isMalposition, Integer isLeave, String leavePcUrl, String leaveMobileUrl, String currentTime, String singleTaskBeginTime, String singleTaskEndTime, String rateSignDate, String rateTaskBeginTime, String rateTaskEndTime) {
        this.stuSignWid = stuSignWid;
        this.signInstanceWid = signInstanceWid;
        this.signWid = signWid;
        this.signRate = signRate;
        this.taskType = taskType;
        this.taskName = taskName;
        this.senderUserName = senderUserName;
        this.signStatus = signStatus;
        this.isMalposition = isMalposition;
        this.isLeave = isLeave;
        this.leavePcUrl = leavePcUrl;
        this.leaveMobileUrl = leaveMobileUrl;
        this.currentTime = currentTime;
        this.singleTaskBeginTime = singleTaskBeginTime;
        this.singleTaskEndTime = singleTaskEndTime;
        this.rateSignDate = rateSignDate;
        this.rateTaskBeginTime = rateTaskBeginTime;
        this.rateTaskEndTime = rateTaskEndTime;
    }

    public Integer getStuSignWid() {
        return stuSignWid;
    }

    public void setStuSignWid(Integer stuSignWid) {
        this.stuSignWid = stuSignWid;
    }

    public Integer getSignInstanceWid() {
        return signInstanceWid;
    }

    public void setSignInstanceWid(Integer signInstanceWid) {
        this.signInstanceWid = signInstanceWid;
    }

    public Integer getSignWid() {
        return signWid;
    }

    public void setSignWid(Integer signWid) {
        this.signWid = signWid;
    }

    public Integer getSignRate() {
        return signRate;
    }

    public void setSignRate(Integer signRate) {
        this.signRate = signRate;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getSenderUserName() {
        return senderUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

    public Integer getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    public Integer getIsMalposition() {
        return isMalposition;
    }

    public void setIsMalposition(Integer isMalposition) {
        this.isMalposition = isMalposition;
    }

    public Integer getIsLeave() {
        return isLeave;
    }

    public void setIsLeave(Integer isLeave) {
        this.isLeave = isLeave;
    }

    public String getLeavePcUrl() {
        return leavePcUrl;
    }

    public void setLeavePcUrl(String leavePcUrl) {
        this.leavePcUrl = leavePcUrl;
    }

    public String getLeaveMobileUrl() {
        return leaveMobileUrl;
    }

    public void setLeaveMobileUrl(String leaveMobileUrl) {
        this.leaveMobileUrl = leaveMobileUrl;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getSingleTaskBeginTime() {
        return singleTaskBeginTime;
    }

    public void setSingleTaskBeginTime(String singleTaskBeginTime) {
        this.singleTaskBeginTime = singleTaskBeginTime;
    }

    public String getSingleTaskEndTime() {
        return singleTaskEndTime;
    }

    public void setSingleTaskEndTime(String singleTaskEndTime) {
        this.singleTaskEndTime = singleTaskEndTime;
    }

    public String getRateSignDate() {
        return rateSignDate;
    }

    public void setRateSignDate(String rateSignDate) {
        this.rateSignDate = rateSignDate;
    }

    public String getRateTaskBeginTime() {
        return rateTaskBeginTime;
    }

    public void setRateTaskBeginTime(String rateTaskBeginTime) {
        this.rateTaskBeginTime = rateTaskBeginTime;
    }

    public String getRateTaskEndTime() {
        return rateTaskEndTime;
    }

    public void setRateTaskEndTime(String rateTaskEndTime) {
        this.rateTaskEndTime = rateTaskEndTime;
    }
}
