package com.root2z.controller.blog;

import com.root2z.controller.BaseController;
import com.root2z.model.entity.Article;
import com.root2z.model.entity.Category;
import com.root2z.model.entity.Comment;
import com.root2z.model.entity.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/about")
public class AboutController extends BaseController {

  @RequestMapping(value = "")
  public ModelAndView about() {
    ModelAndView mv = new ModelAndView();
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

    mv.addObject("topArticles", topArticles);
    mv.addObject("recommendArticles", recommendArticles);
    mv.addObject("newComments", newComments);
    mv.addObject("categoryCount", categoryCount);
    mv.addObject("tagCount", tagCount);
    mv.setViewName("blog/about");
    return mv;
  }
}
