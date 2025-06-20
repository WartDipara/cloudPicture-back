package com.wart.wartpicturebackend.manager;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.wart.wartpicturebackend.config.CosClientConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author Yips
 */
@Component
public class CosManager {
  @Resource
  private CosClientConfig cosClientConfig;
  @Resource
  private COSClient cosClient;
  
  /**
   * 上传对象
   *
   * @param key  唯一键 路径
   * @param file 文件
   */
  public PutObjectResult putObject(String key, File file) {
    PutObjectRequest putObjectRequest = new PutObjectRequest(cosClientConfig.getBucket(), key, file);
    return cosClient.putObject(putObjectRequest);
  }
  
}
