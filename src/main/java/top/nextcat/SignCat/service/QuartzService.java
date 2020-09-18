package top.nextcat.SignCat.service;

import java.util.Date;

public interface QuartzService {
    Date addJob(Class jobClass, String cron,Object data,String jobName);
    void removeJob(String jobName, String groupName);
}
