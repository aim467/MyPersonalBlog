package com.root2z.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** 阿里云OSS配置属性类 */
@Component
@ConfigurationProperties(prefix = "aliyun")
public class AliyunOSSProperties {

  private String bucketName;

  private String urlPrefix;

  private String region;

  private String endpoint;

  private String accessKeyId;

  private String accessKeySecret;

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getAccessKeyId() {
    return accessKeyId;
  }

  public void setAccessKeyId(String accessKeyId) {
    this.accessKeyId = accessKeyId;
  }

  public String getAccessKeySecret() {
    return accessKeySecret;
  }

  public void setAccessKeySecret(String accessKeySecret) {
    this.accessKeySecret = accessKeySecret;
  }

  public String getBucketName() {
    return bucketName;
  }

  public void setBucketName(String bucketName) {
    this.bucketName = bucketName;
  }

  public String getUrlPrefix() {
    return urlPrefix;
  }

  public void setUrlPrefix(String urlPrefix) {
    this.urlPrefix = urlPrefix;
  }

  @Override
  public String toString() {
    return "AliyunOSSProperties{"
        + "region='"
        + region
        + '\''
        + ", endpoint='"
        + endpoint
        + '\''
        + ", accessKeyId='"
        + accessKeyId
        + '\''
        + ", accessKeySecret='"
        + accessKeySecret
        + '\''
        + ", bucketName='"
        + bucketName
        + '\''
        + ", urlPrefix='"
        + urlPrefix
        + '\''
        + '}';
  }
}
