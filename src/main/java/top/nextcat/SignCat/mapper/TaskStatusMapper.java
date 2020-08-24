package top.nextcat.SignCat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.SignInfo;
import top.nextcat.SignCat.model.result.TaskStatus;

@Mapper
public interface TaskStatusMapper extends BaseMapper<TaskStatus> {

    @Select("SELECT * FROM TASK_STATUS WHERE ID=#{id}")
    TaskStatus selectTaskStatusById(Integer id);
}
