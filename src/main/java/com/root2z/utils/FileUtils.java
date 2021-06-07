package com.root2z.utils;

import com.root2z.config.BlogConst;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class FileUtils {

  /**
   * @param file 文件
   * @param fileName 保存的文件名
   * @return
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
    } catch (IllegalStateException e) {
      e.printStackTrace();
      return "";
    } catch (IOException e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * 生成随机文件名
   *
   * @return
   */
  public static String getRandomFileName(String fileName) {

    // 获取后缀
    String suffixName = fileName.substring(fileName.lastIndexOf("."));

    SimpleDateFormat simpleDateFormat;
    simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    Date date = new Date();
    String datetime = simpleDateFormat.format(date);
    Random random = new Random();
    int randNum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 10000;

    String finaName = randNum + datetime + suffixName;

    return finaName;
  }
}
