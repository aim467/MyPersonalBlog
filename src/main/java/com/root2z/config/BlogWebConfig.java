package com.root2z.config;

import com.root2z.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BlogWebConfig implements WebMvcConfigurer {

  private final LoginInterceptor loginInterceptor;

  @Autowired
  public BlogWebConfig(LoginInterceptor loginInterceptor) {
    this.loginInterceptor = loginInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    WebMvcConfigurer.super.addInterceptors(registry);
    registry
        .addInterceptor(loginInterceptor)
        .addPathPatterns("/admin/**")
        .excludePathPatterns("/admin/login")
        .excludePathPatterns("/admin/css/**")
        .excludePathPatterns("/admin/favicon.ico")
        .excludePathPatterns("/admin/fonts/**")
        .excludePathPatterns("/admin/images/**")
        .excludePathPatterns("/admin/js/**")
        .excludePathPatterns("/admin/login");
  }
}
