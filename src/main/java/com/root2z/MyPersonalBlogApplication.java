package com.root2z;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.root2z.dao"})
public class MyPersonalBlogApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyPersonalBlogApplication.class, args);
  }
}
