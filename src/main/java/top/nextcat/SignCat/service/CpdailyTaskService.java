package top.nextcat.SignCat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.SignTask;

import java.util.List;

public interface CpdailyTaskService extends IService<SignTask> {
    public List<SignTask> all ();
}
