package top.nextcat.SignCat.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import top.nextcat.SignCat.model.result.TaskStatus;

import java.io.Serializable;
import java.util.Date;

@TableName("sign_task")
public class SignTask implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
//    @TableField("cpdaily_user_id")
//    @BindEntity(entity = CpdailyUser.class,condition = "this.cpdaily_user_id = id")
    @TableField(exist = false)
    private CpdailyUser signUser;
    @TableField("sign_info_id")
    private SignInfo signInfo;
//    @TableField("task_status_id")
//    @BindEntity(entity = TaskStatus.class,condition = "this.task_status_id = id")
    @TableField(exist = false)
    private TaskStatus taskStatus;
    @TableField("start_date")
    private Date startDate;
    @TableField("pause_date")
    private Date pauseDate;
    @TableField("end_date")
    private Date endDate;
    @JsonIgnore
    @TableField("cron")
    private String cron;

    public SignTask() {
    }

    public SignTask(Integer id, CpdailyUser signUser, SignInfo signInfo, TaskStatus taskStatus, Date startDate, Date pauseDate, Date endDate, String cron) {
        this.id = id;
        this.signUser = signUser;
        this.signInfo = signInfo;
        this.taskStatus = taskStatus;
        this.startDate = startDate;
        this.pauseDate = pauseDate;
        this.endDate = endDate;
        this.cron = cron;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CpdailyUser getSignUser() {
        return signUser;
    }

    public void setSignUser(CpdailyUser signUser) {
        this.signUser = signUser;
    }

    public SignInfo getSignInfo() {
        return signInfo;
    }

    public void setSignInfo(SignInfo signInfo) {
        this.signInfo = signInfo;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getPauseDate() {
        return pauseDate;
    }

    public void setPauseDate(Date pauseDate) {
        this.pauseDate = pauseDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
