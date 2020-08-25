package top.nextcat.SignCat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.SignInfo;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.model.result.TaskStatus;

import java.util.Date;
import java.util.List;

@Mapper
public interface CpdailyTaskMapper extends BaseMapper<SignTask> {
    @Results(id = "signTask", value = {
            @Result(id = true,column = "id",property = "id",javaType = Integer.class),
            @Result(column = "cpdaily_user_id",property = "signUser",javaType = CpdailyUser.class,one = @One(select = "top.nextcat.SignCat.mapper.CpdailyUserMapper.selectCpdailyUserById")),
            @Result(column = "sign_info_id",property = "signInfo",javaType = SignInfo.class,one = @One(select = "top.nextcat.SignCat.mapper.SignInfoMapper.selectSignInfoById")),
            @Result(column = "task_status_id",property = "taskStatus",javaType = TaskStatus.class,one = @One(select = "top.nextcat.SignCat.mapper.TaskStatusMapper.selectTaskStatusById")),
            @Result(column = "start_date",property = "startDate",javaType = Date.class),
            @Result(column = "pause_date",property = "pauseDate",javaType = Date.class),
            @Result(column = "end_date",property = "endDate",javaType = Date.class)
    })
    @Select("SELECT * FROM SIGN_TASK")
    List<SignTask> all();

    @Insert("INSERT INTO SIGN_TASK(CPDAILY_USER_ID,SIGN_INFO_ID) VALUES(#{signUser.id},#{signInfo.id})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    boolean insertSignInfo (SignTask signTask);
}
