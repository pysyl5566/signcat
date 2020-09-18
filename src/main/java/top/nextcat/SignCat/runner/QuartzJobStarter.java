package top.nextcat.SignCat.runner;

import com.alibaba.fastjson.JSON;
import org.quartz.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import top.nextcat.SignCat.job.SignJob;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.model.result.Result;
import top.nextcat.SignCat.service.CpdailyTaskService;
import top.nextcat.SignCat.service.QuartzService;
import top.nextcat.SignCat.service.SignService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Component
public class QuartzJobStarter implements ApplicationRunner {
    @Resource
    CpdailyTaskService cpdailyTaskService;
    @Resource
    SignService signService;
    @Resource
    QuartzService quartzService;
    @Resource
    Scheduler scheduler;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("从数据库中加载任务中ing...");
        List<SignTask> signTasks = cpdailyTaskService.all();

        int success = 0;
        for (SignTask signTask: signTasks) {
            Result result = signService.autoSign(signTask);
            if (result.getErrCode() != 0) {
                System.out.println(result.getErrMsg());
            }
            Date date = quartzService.addJob(SignJob.class,signTask.getCron(),signTask,signTask.getId().toString());

            if (date != null) {
                success++;
                System.out.println(JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss.SSS") + "【签到任务】任务 " + success + "/" + signTasks.size() + " 已加载。");
            } else {
                System.out.println(JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss.SSS") + "【签到任务】任务 " + success + "/" + signTasks.size() + " 加载失败。");
            }
        }

        System.out.print("从数据库中加载任务完毕，共 " + signTasks.size() + " 个任务，");

        if (success == signTasks.size()) {
            System.out.print("全部加载成功。");
            System.out.println();
        } else {
            System.out.print("其中 " + (signTasks.size() - success) + " 个加载失败。");
            System.out.println();
        }

//        JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName("top.nextcat.SignCat.job.SignJob")).storeDurably().build();
//        CronTrigger cronTrigger = TriggerBuilder.newTrigger().startNow().withSchedule(CronScheduleBuilder.cronSchedule("00 15 19 ? * *")).build();

//        scheduler.scheduleJob(jobDetail,cronTrigger);
    }
}
