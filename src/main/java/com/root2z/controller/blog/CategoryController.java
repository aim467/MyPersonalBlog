package com.root2z.controller.blog;

import com.github.pagehelper.PageInfo;
import com.google.gson.JsonElement;
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
@RequestMapping(value = "/category")
public class CategoryController extends BaseController {

  @RequestMapping(value = "")
  public ModelAndView categoryListById(
      @RequestParam(value = "id", required = false) Integer categoryId,
      @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
      @RequestParam(value = "size", defaultValue = "5", required = false) Integer size) {

    // 分类ID不好给默认值，从数据库查询第一个，针对直接从导航条点击到分类区域
    if (categoryId == null) {
      categoryId = categoryService.getCategoryId();
    }

    PageInfo<Article> articles = articleService.getAllByCategory(categoryId, page, size);

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

    List<Category> categories = categoryService.getAllCategories();

    ModelAndView mv = new ModelAndView();
    mv.addObject("topArticles", topArticles);
    mv.addObject("recommendArticles", recommendArticles);
    mv.addObject("newComments", newComments);
    mv.addObject("categoryCount", categoryCount);
    mv.addObject("tagCount", tagCount);
    mv.addObject("categories", categories);

    // 根据对应的分类ID查到文章记录
    mv.addObject("articles", articles);
    mv.setViewName("blog/categories");
    return mv;
  }
}
