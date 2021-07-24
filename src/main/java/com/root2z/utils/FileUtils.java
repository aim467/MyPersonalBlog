package com.root2z.utils;

import com.root2z.config.BlogConst;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FileUtils {

  /**
   * @param file 文件
   * @param fileName 保存的文件名
   */
  public static String upload(MultipartFile file, String fileName) {

    String randomFileName = getRandomFileName(fileName);

    // 确定上传的文件名
    String realPath = BlogConst.ImagePath + randomFileName;

    File dest = new File(realPath);

    // 判断文件父目录是否存在
    if (!dest.getParentFile().exists()) {
      dest.getParentFile().mkdir();
    }

    try {
      // 保存文件
      file.transferTo(dest);
      return randomFileName;
    } catch (IllegalStateException | IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * 生成随机文件名
   *
   * @param fileName 文件名
   */
  public static String getRandomFileName(String fileName) {
    // 获取后缀
    String suffixName = fileName.substring(fileName.lastIndexOf("."));
    SimpleDateFormat simpleDateFormat;
    simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    Date date = new Date();
    // 获得当前时间
    String datetime = simpleDateFormat.format(date);
    Random random = new Random();
    // 提取时间
    int randNum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 10000;
    return randNum + datetime + suffixName;
  }
}
