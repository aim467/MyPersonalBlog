package com.root2z.controller.blog;

import com.root2z.controller.BaseController;
import com.root2z.model.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/friends")
public class LinkController extends BaseController {

  @RequestMapping("")
  public ModelAndView friends() {
    // 拿到置顶文章
    List<Article> topArticles = articleService.getTopArticle(4);
    // 拿到推荐文章
    List<Article> recommendArticles = articleService.getRecommendArticle(3);
    // 拿到最新评论
    List<Comment> newComments = commentService.getNewComments(4);
    // 拿到分类统计
    List<Category> categoryCount = categoryService.getCategoryCount();
    // 拿到标签统计
    List<Tag> tagCount = tagService.getTagCount();

    List<Friend> friends = friendService.listFriends();

    List<Message> messages = messageService.listMessage();

    ModelAndView mv = new ModelAndView();
    mv.addObject("topArticles", topArticles);
    mv.addObject("recommendArticles", recommendArticles);
    mv.addObject("newComments", newComments);
    mv.addObject("categoryCount", categoryCount);
    mv.addObject("tagCount", tagCount);
    mv.addObject("messages", messages);
    mv.addObject("messageCount", messageService.countMessage());
    mv.addObject("friends", friends);
    mv.setViewName("blog/friends");
    return mv;
  }
}
