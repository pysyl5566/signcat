package top.nextcat.SignCat.helper;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Headers;
import top.nextcat.SignCat.aliyun.OSSConfig;
import top.nextcat.SignCat.api.AliyunOSSApi;
import top.nextcat.SignCat.api.BaseURL;
import top.nextcat.SignCat.model.CpdailyUser;
import top.nextcat.SignCat.model.HttpContext;
import top.nextcat.SignCat.model.UploadFile;
import top.nextcat.SignCat.model.result.ResultAliyunOSSInfo;

import java.io.File;

public class ImageHelper {
    public static String upload (CpdailyUser cpdailyUser, String modAuthCas, File imageFile) {
        ResultAliyunOSSInfo resultAliyunOSSInfo = AliyunOSSHelper.getAliyunOSSInfo(cpdailyUser, modAuthCas);

        if (resultAliyunOSSInfo == null) {
            return "";
        }

        OSSConfig ossConfig = new OSSConfig();
        ossConfig.setAccessKeyId(resultAliyunOSSInfo.getDatas().getAccessKeyId());
        ossConfig.setAccessKeySecret(resultAliyunOSSInfo.getDatas().getAccessKeySecret());
        ossConfig.setBucketName(resultAliyunOSSInfo.getDatas().getBucket());
        ossConfig.setEndpoint(resultAliyunOSSInfo.getDatas().getEndPoint());
        ossConfig.setSecurityToken(resultAliyunOSSInfo.getDatas().getSecurityToken());
        UploadFile uploadFile = new UploadFile();
        uploadFile.setFile(imageFile);
        uploadFile.setObjectName(resultAliyunOSSInfo.getDatas().getFileName());

        if (AliyunOSSHelper.uploadFile(ossConfig,uploadFile)) {
            return resultAliyunOSSInfo.getDatas().getFileName();
        }

        return "";
    }
}
