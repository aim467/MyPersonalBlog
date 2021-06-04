package com.root2z.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
public class KaptchaController {

  private final DefaultKaptcha defaultKaptcha;

  @Autowired
  public KaptchaController(DefaultKaptcha defaultKaptcha) {
    this.defaultKaptcha = defaultKaptcha;
  }

  /**
   * 生成验证码
   *
   * @param request
   * @param response
   * @throws IOException
   */
  @GetMapping("/defaultKaptcha")
  public void defaultKaptcha(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    byte[] captchaOutputStream = null;
    ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
    try {
      // 生产验证码字符串并保存到session中
      String verifyCode = defaultKaptcha.createText();
      request.getSession().setAttribute("verifyCode", verifyCode);
      // 创建缓冲图片
      BufferedImage challenge = defaultKaptcha.createImage(verifyCode);
      // 写入图片
      ImageIO.write(challenge, "jpg", imgOutputStream);
    } catch (IllegalArgumentException e) {
      response.sendError(HttpServletResponse.SC_NOT_FOUND);
      return;
    }
    captchaOutputStream = imgOutputStream.toByteArray();
    // 设置响应头
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");
    ServletOutputStream responseOutputStream = response.getOutputStream();
    // 写入到响应体中
    responseOutputStream.write(captchaOutputStream);
    responseOutputStream.flush();
    responseOutputStream.close();
  }
}
