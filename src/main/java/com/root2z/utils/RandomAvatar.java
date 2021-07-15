package com.root2z.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

import java.io.IOException;

/** 随机头像生成 */
public class RandomAvatar {

  /** 请求Base64接口 */
  private static final String Base64URL = "https://api.prodless.com/avatar";

  /** 请求图片接口 */
  private static final String ImageURL = "https://api.prodless.com/avatar.png";

  /**
   * 获得Base64编码的图片
   *
   * @return 返回Base64编码的图片
   */
  public static String getBase64Avatar() throws IOException {
    Request request = new Builder().url(Base64URL).build();
    OkHttpClient okHttpClient = new OkHttpClient();
    Response response = okHttpClient.newCall(request).execute();
    String avatarUrl = response.body().string();
    String Base64Prefix = "data:image/png;base64,";
    return Base64Prefix + avatarUrl;
  }

  public static void main(String[] args) throws IOException {
    System.out.println(RandomAvatar.getBase64Avatar());
  }
}
