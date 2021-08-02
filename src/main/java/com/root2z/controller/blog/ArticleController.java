package com.root2z.controller.blog;

import com.root2z.controller.BaseController;
import com.root2z.model.entity.Article;
import com.root2z.model.entity.Category;
import com.root2z.model.entity.Comment;
import com.root2z.model.entity.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController extends BaseController {

  /**
   * 进入某个博客的详情页面
   *
   * @param articleId
   * @return
   */
  @RequestMapping(value = "/{id}")
  public ModelAndView articleDetail(@PathVariable("id") Integer articleId) {
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
    // 拿到当前文章的所有评论
    List<Comment> commentList = commentService.listComment(articleId);

    Article article = articleService.getArticleById(articleId);

    ModelAndView mv = new ModelAndView();
    mv.addObject("topArticles", topArticles);
    mv.addObject("recommendArticles", recommendArticles);
    mv.addObject("newComments", newComments);
    mv.addObject("categoryCount", categoryCount);
    mv.addObject("tagCount", tagCount);
    mv.addObject("currentArticle", article);
    mv.addObject("commentList", commentList);
    mv.setViewName("blog/detail");
    return mv;
  }
}
