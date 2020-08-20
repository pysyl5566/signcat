package top.nextcat.SignCat.aliyun;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import top.nextcat.SignCat.model.UploadFile;

public class OSSHelper {
    public static boolean uploadFile (OSSConfig ossConfig, UploadFile uploadFile) {
        OSS ossClient = new OSSClientBuilder().build(ossConfig.getEndpoint(), ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret());
        PutObjectRequest putObjectRequest = new PutObjectRequest(ossConfig.getBucketName(), uploadFile.getObjectName(), uploadFile.getFile());
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setHeader(OSSHeaders.OSS_SECURITY_TOKEN, ossConfig.getSecurityToken());
        putObjectRequest.setMetadata(metadata);

        try {
            ossClient.putObject(putObjectRequest);
        } catch (Exception exception) {
            return false;
        }

        ossClient.shutdown();
        return true;
    }


}
