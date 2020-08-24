package top.nextcat.SignCat.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.nextcat.SignCat.mapper.TaskStatusMapper;
import top.nextcat.SignCat.model.result.TaskStatus;
import top.nextcat.SignCat.service.TaskStatusService;

@Service
public class TaskStatusServiceImpl extends ServiceImpl<TaskStatusMapper, TaskStatus> implements TaskStatusService {


}
