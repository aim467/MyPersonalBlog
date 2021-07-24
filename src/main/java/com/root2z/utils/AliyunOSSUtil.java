package com.root2z.utils;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.root2z.config.AliyunOSSProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Component
public class AliyunOSSUtil {

  private final AliyunOSSProperties aliyunOSSProperties;

  private static final Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);

  private final ClientBuilderConfiguration builderConfiguration = new ClientBuilderConfiguration();

  @Autowired
  public AliyunOSSUtil(AliyunOSSProperties aliyunOSSProperties) {
    this.aliyunOSSProperties = aliyunOSSProperties;
    // 设置网络参数
    builderConfiguration.setConnectionTimeout(15 * 1000);
    builderConfiguration.setSocketTimeout(15 * 1000);
    builderConfiguration.setMaxConnections(8);
    builderConfiguration.setMaxErrorRetry(2);
  }

  /**
   * 进行图片上传
   *
   * @param file 文件对象
   * @param storagePath 存储路径
   * @return 图片访问地址
   */
  public String uploadFile(MultipartFile file, String storagePath) {
    OSS ossClient =
        new OSSClientBuilder()
            .build(
                aliyunOSSProperties.getEndpoint(),
                aliyunOSSProperties.getAccessKeyId(),
                aliyunOSSProperties.getAccessKeySecret(),
                builderConfiguration);
    String fileName =
        FileUtils.getRandomFileName(Objects.requireNonNull(file.getOriginalFilename()));
    try {
      InputStream inputStream = file.getInputStream();

      // 设置文件的头信息
      ObjectMetadata objectMetadata = new ObjectMetadata();
      objectMetadata.setCacheControl("no-cache");
      objectMetadata.setContentLength(inputStream.available());
      objectMetadata.setHeader("Pragma", "no-cache");
      objectMetadata.setContentType(file.getContentType());
      objectMetadata.setContentDisposition("inline;filename=" + fileName);

      fileName = !StringUtils.isEmpty(storagePath) ? storagePath + "/" + fileName : fileName;

      PutObjectResult result =
          ossClient.putObject(
              aliyunOSSProperties.getBucketName(), fileName, inputStream, objectMetadata);
      logger.info("Aliyun OSS AliyunOSSUtil.uploadFileToAliyunOSS,result:{}", result.toString());

    } catch (IOException e) {
      e.printStackTrace();
    }
    ossClient.shutdown();
    return aliyunOSSProperties.getUrlPrefix() + fileName;
  }

  /**
   * 删除文件
   *
   * @param fileName 文件名
   */
  public void deleteFile(String fileName) {
    OSS ossClient =
        new OSSClientBuilder()
            .build(
                aliyunOSSProperties.getEndpoint(),
                aliyunOSSProperties.getAccessKeyId(),
                aliyunOSSProperties.getAccessKeySecret(),
                builderConfiguration);
    // 根除bucketName开头
    String lastFileName = fileName.substring(fileName.lastIndexOf("/") + 1);
    try {
      ossClient.deleteObject(aliyunOSSProperties.getBucketName(), lastFileName);
    } catch (Exception e) {
      e.printStackTrace();
    }
    ossClient.shutdown();
  }
}
