package com.root2z;

import com.root2z.dao.ArticleMapper;
import com.root2z.dao.TagMapper;
import com.root2z.service.ArticleService;
import com.root2z.service.CommentService;
import com.root2z.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyPersonalBlogApplicationTests {

  @Autowired private CommentService commentService;

  @Test
  void contextLoads() {
    System.out.println(commentService.listComment(14));
  }
}
