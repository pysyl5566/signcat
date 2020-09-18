package top.nextcat.SignCat.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.quartz.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.nextcat.SignCat.helper.*;
import top.nextcat.SignCat.job.SignJob;
import top.nextcat.SignCat.model.CpdailyInfo;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.SignInfo;
import top.nextcat.SignCat.model.SignTask;
import top.nextcat.SignCat.model.result.*;
import top.nextcat.SignCat.pojo.DataTables;
import top.nextcat.SignCat.service.*;
import top.nextcat.SignCat.utils.RandomGUIDUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CpdailySignController {
    @Resource
    CpdailyTaskService cpdailyTaskService;
    @Resource
    SignInfoService signInfoService;
    @Resource
    QuartzService quartzService;
    @Resource
    CpdailyUserService cpdailyUserService;
    @Resource
    SignService signService;
    @Resource
    private Scheduler scheduler;

    @GetMapping("/v1/cpdaily/sign/list")
    @ResponseBody
    public DataTables cpdailySignList (HttpServletRequest request) {
        DataTables dataTables = new DataTables();
        List<SignTask> signTasks = cpdailyTaskService.all();

        if (signTasks != null) {
            dataTables.setCode(0);
            dataTables.setCount(signTasks.size());
            dataTables.setData(signTasks);
            dataTables.setMsg("获取所有今日校园签到任务成功。");
        }
        return dataTables;
    }

    @PostMapping("/v1/cpdaily/sign/add")
    @ResponseBody
    public Result cpdailySignAdd (HttpServletRequest request, @RequestBody SignTask signTask) {
        Result result = new Result();

        signTask.setSignUser(cpdailyUserService.getById(signTask.getSignUser().getId()));

        String modAuthCas = AuthHelper.getModAuthCas(signTask.getSignUser());

        String imageLocalFolder = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/images";

        String imagePath = "";
        if (signTask.getSignInfo().getSignPhotoUrl() != null && !"".equals(signTask.getSignInfo().getSignPhotoUrl())) {
            imagePath = imageLocalFolder + "/sign/" + signTask.getSignInfo().getSignPhotoUrl();

            String imageUploadPath = ImageHelper.upload(signTask.getSignUser(),modAuthCas,new File(imagePath));

            if ("".equals(imageUploadPath)) {
                result.setErrCode(-2);
                result.setErrMsg("上传签到照片失败！");
                return result;
            }
            signTask.getSignInfo().setSignPhotoUrl("https://wecres.cpdaily.com/" + imageUploadPath);
//            imagePath = imageLocalFolder + "/avatar.png";
        }

        SignInfo signInfo = signTask.getSignInfo();

        if (!signInfoService.save(signTask.getSignInfo())) {
            result.setErrCode(-10);
            result.setErrMsg("新增签到信息失败！");
            return result;
        }

        signTask.setSignInfo(signInfo);

        System.out.println(JSONObject.toJSONString(signTask));


        ResultSignInfo resultSignInfo = SignHelper.getSignInfo(signTask.getSignUser(),modAuthCas);

        if (resultSignInfo != null) {
            String imageBaseUrl = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/images";
            MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
            mapperFactory.classMap(SignTask.class, SignTask.class)
                    .byDefault()
                    .register();
            ConverterFactory converterFactory = mapperFactory.getConverterFactory();
            MapperFacade mapper = mapperFactory.getMapperFacade();

//            signService.autoSign(signTask);

            for (ResultSignTask resultSignTask : resultSignInfo.getDatas().getUnSignedTasks()) {
                String cron = "00 {0} {1} ? * *";
                SignTask st = mapper.map(signTask, SignTask.class);

                if (TimeHelper.isNeedSign(resultSignTask.getRateSignDate(),resultSignTask.getRateTaskBeginTime(),resultSignTask.getCurrentTime())) {
                    st.getSignInfo().setSignInstanceWid(resultSignTask.getSignInstanceWid());
                    signService.sign(st);
                }

                cron = MessageFormat.format(cron, StringHelper.getSubString(resultSignTask.getRateTaskBeginTime(),":",""),StringHelper.getSubString(resultSignTask.getRateTaskBeginTime(),"",":"));
                st.setCron(cron);
                signService.addAutoSignJob(st);
            }

            for (ResultSignTask resultSignTask : resultSignInfo.getDatas().getSignedTasks()) {
                String cron = "00 {0} {1} ? * *";
                SignTask st = mapper.map(signTask, SignTask.class);

                cron = MessageFormat.format(cron, StringHelper.getSubString(resultSignTask.getRateTaskBeginTime(),":",""),StringHelper.getSubString(resultSignTask.getRateTaskBeginTime(),"",":"));
                st.setCron(cron);
                signService.addAutoSignJob(st);
            }
        } else {
            result.setErrCode(-9);
            result.setErrMsg("获取签到信息失败，可能是会话信息失效！");
            return result;
        }

        result.setErrCode(0);
        return result;
    }

    @PostMapping("/v1/cpdaily/sign/uploadImage")
    @ResponseBody
    public Object uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        Result result = new Result();

        if (file.isEmpty()) {
            System.out.println("上传失败");
        }
        String fileName = file.getOriginalFilename();
        String filePath = ClassUtils.getDefaultClassLoader().getResource("static").getPath() + "/images/sign/";
        String suffix = fileName.substring(fileName.lastIndexOf("."),fileName.length());
        System.out.println(filePath);
        File saveFile = new File(filePath);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }

        String imagePath = new RandomGUIDUtils().toString();
        saveFile = new File(filePath + imagePath + suffix);

        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            System.out.println(e.toString());
            result.setErrCode(-1);
            result.setErrMsg("上传签到照片失败。");
            return result;
        }

        result.setErrCode(0);
        ResultImageUpload resultImageUpload = new ResultImageUpload();
        resultImageUpload.setImagePath(imagePath + suffix);
        result.setData(resultImageUpload);

        return result;
    }
}
