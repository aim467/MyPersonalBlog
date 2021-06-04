package com.root2z.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class KaptchaConfig {

  /**
   * 验证码Bean
   *
   * @return
   */
  @Bean
  public DefaultKaptcha getDefaultKaptcha() {
    com.google.code.kaptcha.impl.DefaultKaptcha defaultKaptcha =
        new com.google.code.kaptcha.impl.DefaultKaptcha();
    // 验证码属性
    Properties properties = new Properties();
    // 图片边框
    properties.setProperty("kaptcha.border", "no");
    // 边框颜色
    properties.setProperty("kaptcha.border.color", "105,179,90");
    // 字体颜色
    properties.setProperty("kaptcha.textproducer.font.color", "black");
    // 图片宽
    properties.setProperty("kaptcha.image.width", "110");
    // 图片高
    properties.setProperty("kaptcha.image.height", "40");
    // 字体大小
    properties.setProperty("kaptcha.textproducer.font.size", "30");
    // session key
    properties.setProperty("kaptcha.session.key", "code");
    // 验证码长度
    properties.setProperty("kaptcha.textproducer.char.length", "4");
    // 字体
    properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
    Config config = new Config(properties);
    defaultKaptcha.setConfig(config);
    return defaultKaptcha;
  }
}
