package com.root2z.controller.admin;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Article;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminArticleController {

  private final Logger logger = LoggerFactory.getLogger(AdminArticleController.class);

  private final CategoryService categoryService;

  private final ArticleService articleService;

  @Autowired
  public AdminArticleController(
      CategoryService categoryService, TagService tagService, ArticleService articleService) {
    this.categoryService = categoryService;
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
   * @param articleVO 文章视图对象
   * @return 是否保存文章成功消息
   */
  @RequestMapping(value = "/article/add", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO saveArticle(ArticleVO articleVO) {
    // 保存文章
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

  /**
   * 拿到当前的文章，回到编辑文章页面
   *
   * @param id 文章ID
   * @return 视图名字
   */
  @RequestMapping(value = "/article/edit/{id}")
  public ModelAndView editArticlePage(@PathVariable Integer id) {
    ModelAndView mv = new ModelAndView();
    // 拿到所有分类
    mv.addObject("categories", categoryService.getAllCategories());

    // 查询出文章信息
    ArticleVO articleVO = articleService.getArticleInfo(id);

    // 设置tag
    String tags = String.join(",", articleVO.getTags());
    mv.addObject("tags", tags);

    // 设置文章对象
    mv.addObject("editArticle", articleVO);
    mv.setViewName("admin/article/edit");
    return mv;
  }

  @RequestMapping(value = "/article/edit/", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO updateArticle(ArticleVO articleVO) {
    if (articleService.editArticle(articleVO)) {
      return ResultUtil.success("更新文章成功!", null);
    }
    return ResultUtil.error("更新文章失败", null);
  }

  /**
   * 返回文章分类列表
   *
   * @param pageNum
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/articles", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, Object> articleList(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {
    Map<String, Object> result = new HashMap<>();
    PageInfo<Article> pageArticles = articleService.pageQuery(pageNum, pageSize);
    result.put("total", pageArticles.getTotal());
    result.put("rows", pageArticles.getList());
    return result;
  }

  @RequestMapping(value = "/articles")
  public String articlesPage() {
    return "admin/article/list";
  }

  @RequestMapping(value = "/article/status", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO changeStatus(
      @RequestParam("articleId") Integer articleId, @RequestParam("status") Integer status) {
    if (articleService.updateArticleStatus(articleId, status)) {
      return ResultUtil.success("更新文章状态成功!", null);
    }
    return ResultUtil.error("更改文章状态失败!", null);
  }
}
