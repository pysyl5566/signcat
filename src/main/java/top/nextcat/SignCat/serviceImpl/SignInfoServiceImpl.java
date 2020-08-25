package top.nextcat.SignCat.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.nextcat.SignCat.mapper.SignInfoMapper;
import top.nextcat.SignCat.model.SignInfo;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.service.SignInfoService;

import javax.annotation.Resource;

@Service
public class SignInfoServiceImpl extends ServiceImpl<SignInfoMapper, SignInfo> implements SignInfoService {
//    @Resource
//    SignInfoMapper signInfoMapper;
}
