package top.nextcat.SignCat.serviceImpl;

import org.quartz.*;
import org.springframework.stereotype.Service;
import top.nextcat.SignCat.service.QuartzService;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class QuartzServiceImpl implements QuartzService {
    @Resource
    private Scheduler scheduler;

    @Override
    public Date addJob(Class jobClass, String cron,Object data,String jobName) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("data",data);
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity( jobClass.getSimpleName() + "_" + jobName,jobClass.getSimpleName()).storeDurably().setJobData(jobDataMap).build();
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(jobClass.getSimpleName() + "_" + jobName,jobClass.getSimpleName()).startNow().withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        System.out.println("执行任务中ing...");
        Date date = null;
        try {
            date = scheduler.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return null;
        }

        return date;
    }

    @Override
    public void removeJob(String jobName, String groupName) {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, groupName);
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            JobKey jobKey = JobKey.jobKey(jobName, groupName);
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
