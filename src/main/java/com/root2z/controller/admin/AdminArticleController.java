package com.root2z.controller.admin;

import com.root2z.model.vo.ArticleVO;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.ArticleService;
import com.root2z.service.CategoryService;
import com.root2z.service.TagService;
import com.root2z.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;

/** TODO 文章列表的展示，文章的编辑，文章的分类与标签处理 */
@Controller
@RequestMapping("/admin")
public class AdminArticleController {

  private Logger logger = LoggerFactory.getLogger(AdminArticleController.class);

  private final CategoryService categoryService;

  private final ArticleService articleService;

  private final TagService tagService;

  @Autowired
  public AdminArticleController(
      CategoryService categoryService, TagService tagService, ArticleService articleService) {
    this.categoryService = categoryService;
    this.tagService = tagService;
    this.articleService = articleService;
  }

  /**
   * 进入新增文章视图
   *
   * @return 视图
   */
  @RequestMapping("/article/add")
  public ModelAndView addArticlePage() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("categories", categoryService.getAllCategories());
    mv.setViewName("admin/article/add");
    return mv;
  }

  /**
   * 保存文章动作
   *
   * @param articleVO
   * @return
   */
  @RequestMapping(value = "/article/add", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO saveArticle(ArticleVO articleVO) {
    if (articleService.addArticle(articleVO)) {
      return ResultUtil.success("保存文章成功!", null);
    }
    return ResultUtil.error("新增文章失败", null);
  }

  /**
   * 根据ID删除文章
   *
   * @return
   */
  @RequestMapping(value = "/article/delete/{id}", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO deleteArticle(@PathVariable Integer id) {
    if (articleService.deleteArticle(id)) {
      return ResultUtil.success("删除文章成功!", null);
    }
    return ResultUtil.error("删除文章失败!", null);
  }
}
