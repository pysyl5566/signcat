package top.nextcat.SignCat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.SignInfo;
import top.nextcat.SignCat.model.SignTask;

@Mapper
public interface SignInfoMapper extends BaseMapper<SignInfo> {
    @Select("SELECT * FROM SIGN_INFO WHERE ID=#{id}")
    SignInfo selectSignInfoById(Integer id);
}
