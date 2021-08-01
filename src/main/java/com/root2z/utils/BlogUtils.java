package com.root2z.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class BlogUtils {

  private static final String WallpaperUrl = "https://api.ixiaowai.cn/gqapi/gqapi.php?return=json";

  /**
   * 获取一个随机壁纸
   *
   * @return
   */
  public static String randomWallpaper() {
    Request request = new Request.Builder().url(WallpaperUrl).build();
    OkHttpClient okHttpClient = new OkHttpClient();
    Response response = null;
    try {
      response = okHttpClient.newCall(request).execute();
      ObjectMapper objectMapper = new ObjectMapper();
      RandomWallPaper wallPaper =
          objectMapper.readValue(response.body().string(), RandomWallPaper.class);
      return wallPaper.getImgurl();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}

class RandomWallPaper {
  private Integer code;
  private String imgurl;
  private Integer width;
  private Integer height;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getImgurl() {
    return imgurl;
  }

  public void setImgurl(String imgurl) {
    this.imgurl = imgurl;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }
}
