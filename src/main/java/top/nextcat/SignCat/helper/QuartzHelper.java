package top.nextcat.SignCat.helper;

import org.quartz.*;
import top.nextcat.SignCat.job.SignJob;

import javax.annotation.Resource;

public class QuartzHelper {
    @Resource
    private static Scheduler scheduler;

    public static void addTask(Class jobClass,String cron) {
        JobDetail jobDetail = JobBuilder.newJob(jobClass).storeDurably().build();
//        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withIntervalInDays(1).withInterval())
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().startNow().withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        System.out.println("执行任务中ing...");
        try {
            scheduler.scheduleJob(jobDetail,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
