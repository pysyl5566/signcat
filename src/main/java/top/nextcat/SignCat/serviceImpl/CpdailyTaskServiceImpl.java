package top.nextcat.SignCat.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.nextcat.SignCat.mapper.CpdailyTaskMapper;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.service.CpdailyTaskService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CpdailyTaskServiceImpl extends ServiceImpl<CpdailyTaskMapper, SignTask> implements CpdailyTaskService {
    @Resource
    private CpdailyTaskMapper cpdailyTaskMapper;

    @Override
    public List<SignTask> all() {
        return cpdailyTaskMapper.all();
    }

    @Override
    public boolean insertSignTask(SignTask signTask) {
        return cpdailyTaskMapper.insertSignInfo(signTask);
    }

    @Override
    public boolean updateStartDateById(SignTask signTask) {
        return cpdailyTaskMapper.updateStartDateById(signTask);
    }
}
