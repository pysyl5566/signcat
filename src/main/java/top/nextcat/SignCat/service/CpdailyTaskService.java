package top.nextcat.SignCat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.nextcat.SignCat.model.SignTask;

import java.util.List;

public interface CpdailyTaskService extends IService<SignTask> {
    List<SignTask> all();
    boolean insertSignTask(SignTask signTask);
    boolean updateStartDateById(SignTask signTask);
}
