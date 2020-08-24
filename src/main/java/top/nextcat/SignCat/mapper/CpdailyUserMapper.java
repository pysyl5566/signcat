package top.nextcat.SignCat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.nextcat.SignCat.model.CpdailyUser;

@Mapper
public interface CpdailyUserMapper extends BaseMapper<CpdailyUser> {

    @Select("SELECT * FROM CPDAILY_USER WHERE ID=#{id}")
    CpdailyUser selectCpdailyUserById(Integer id);
}
