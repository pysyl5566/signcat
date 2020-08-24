package top.nextcat.SignCat.model.result;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;

@TableName("task_status")
public class TaskStatus {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("status_name")
    private String statusName;

    @JsonIgnore
    public boolean isRunning () {
        return id == 1;
    }

    @JsonIgnore
    public boolean isPaused () {
        return id == 2;
    }

    @JsonIgnore
    public boolean isStopped () {
        return id == 3;
    }

    public TaskStatus(Integer id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
