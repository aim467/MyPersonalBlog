package com.root2z.controller.blog;

import com.github.pagehelper.PageInfo;
import com.root2z.controller.BaseController;
import com.root2z.model.entity.Article;
import com.root2z.model.entity.Category;
import com.root2z.model.entity.Comment;
import com.root2z.model.entity.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/tag")
public class TagController extends BaseController {

  /**
   * 标签列表
   *
   * @return
   */
  @RequestMapping(value = "")
  public ModelAndView tagList(
      @RequestParam(value = "id", required = false) Integer tagId,
      @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
      @RequestParam(value = "size", defaultValue = "5", required = false) Integer size) {

    if (tagId == null) {
      tagId = tagService.getTagId();
    }

    PageInfo<Article> articles = articleService.getAllByTagId(tagId, page, size);
    List<Tag> tags = tagService.getAllTags();

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
    mv.addObject("recommendArticles", recommendArticles);
    mv.addObject("newComments", newComments);
    mv.addObject("categoryCount", categoryCount);
    mv.addObject("tagCount", tagCount);
    mv.addObject("articles", articles);
    mv.addObject("tags", tags);
    mv.setViewName("blog/tags");
    return mv;
  }
}
