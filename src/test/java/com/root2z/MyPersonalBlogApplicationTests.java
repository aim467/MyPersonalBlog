package com.root2z;

import com.root2z.dao.ArticleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyPersonalBlogApplicationTests {

  @Autowired private ArticleMapper articleMapper;

  @Test
  void contextLoads() {
    System.out.println(articleMapper.selectAllCategoryId(21));
  }
}
