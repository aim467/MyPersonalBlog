package com.root2z.utils;

import java.security.MessageDigest;

public class MD5Utils {
  /**
   * 字节数组转成十六进制字符串
   *
   * @param b
   * @return
   */
  private static String byteArrayToHexString(byte b[]) {
    StringBuffer resultSb = new StringBuffer();
    for (int i = 0; i < b.length; i++) resultSb.append(byteToHexString(b[i]));

    return resultSb.toString();
  }

  /**
   * 单字节转成十六进制字符串
   *
   * @param b
   * @return
   */
  private static String byteToHexString(byte b) {
    int n = b;
    if (n < 0) n += 256;
    int d1 = n / 16;
    int d2 = n % 16;
    return hexDigits[d1] + hexDigits[d2];
  }

  /**
   * MD5加密
   *
   * @param origin
   * @param charsets
   * @return
   */
  public static String MD5Encode(String origin, String charsets) {
    String resultString = null;
    try {
      resultString = new String(origin);
      MessageDigest md = MessageDigest.getInstance("MD5");
      if (charsets == null || "".equals(charsets))
        resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
      else resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsets)));
    } catch (Exception exception) {
    }
    return resultString;
  }

  private static final String hexDigits[] = {
    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
  };

  public static void main(String[] args) {
    String pass = MD5Utils.MD5Encode("123", "");
    System.out.println(pass);
  }
}
