package com.root2z.controller.blog;

import com.github.pagehelper.PageInfo;
import com.root2z.controller.BaseController;
import com.root2z.model.entity.Article;
import com.root2z.model.entity.Category;
import com.root2z.model.entity.Comment;
import com.root2z.model.entity.Tag;
import com.root2z.model.vo.ArticleVO;
import com.root2z.model.vo.FrontArticleVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class IndexController extends BaseController {

  private final Logger logger = LoggerFactory.getLogger(IndexController.class);

  /** 博客首页 */
  @RequestMapping
  public ModelAndView index(
      @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
      @RequestParam(value = "size", defaultValue = "2", required = false) Integer size) {
    // 根据文章更新时间拿到拿到文章列表
    PageInfo<Article> articleList = articleService.getArticleByTime(page, size);

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

    ModelAndView mv = new ModelAndView();
    mv.addObject("topArticles", topArticles);
    mv.addObject("articleList", articleList);
    mv.addObject("recommendArticles", recommendArticles);
    mv.addObject("newComments", newComments);
    mv.addObject("categoryCount", categoryCount);
    mv.addObject("tagCount", tagCount);
    mv.setViewName("blog/index");
    return mv;
  }
}
