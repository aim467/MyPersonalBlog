package com.root2z;

import com.root2z.dao.ArticleMapper;
import com.root2z.model.entity.Article;
import com.root2z.model.vo.ArticleVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyPersonalBlogApplicationTests {

  @Autowired private ArticleMapper articleMapper;

  @Test
  void contextLoads() {

    Article article = articleMapper.selectByPrimaryKey(7);
    ArticleVO articleVO = new ArticleVO();
    BeanUtils.copyProperties(article, articleVO);
    System.out.println(articleVO);
  }
}
