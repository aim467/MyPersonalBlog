package com.root2z.controller.admin;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Article;
import com.root2z.model.entity.Tag;
import com.root2z.model.vo.ArticleVO;
import com.root2z.model.vo.ResultVO;
import com.root2z.model.vo.TagVO;
import com.root2z.service.ArticleService;
import com.root2z.service.CategoryService;
import com.root2z.service.TagService;
import com.root2z.utils.AliyunOSSUtil;
import com.root2z.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminArticleController {

  @Resource private AliyunOSSUtil aliyunOSSUtil;

  private final CategoryService categoryService;

  private final ArticleService articleService;

  private final TagService tagService;

  @Autowired
  public AdminArticleController(
      CategoryService categoryService, TagService tagService, ArticleService articleService) {
    this.categoryService = categoryService;
    this.articleService = articleService;
    this.tagService = tagService;
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
    mv.addObject("tags", tagService.getAllTags());
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
    return articleService.addArticle(articleVO);
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
    List<Tag> tags = tagService.getAllTags();
    List<TagVO> tagVOS = new ArrayList<>();

    // 拷贝列表
    for (Tag tag : tags) {
      TagVO tagVO = new TagVO();
      BeanUtils.copyProperties(tag, tagVO);
      tagVOS.add(tagVO);
    }
    // 遍历选中的标签名字，设置selected
    for (String tagName : articleVO.getTags()) {
      for (TagVO tagVO : tagVOS) {
        if (tagVO.getName().equals(tagName)) {
          tagVO.setSelected(true);
        }
      }
    }
    mv.addObject("tagVOS", tagVOS);
    // 设置文章对象
    mv.addObject("editArticle", articleVO);
    mv.setViewName("admin/article/edit");
    return mv;
  }

  @RequestMapping(value = "/article/edit/", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO updateArticle(ArticleVO articleVO) {
    return articleService.editArticle(articleVO);
  }

  /**
   * 返回文章分类列表
   *
   * @param pageNum
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/articles", method = RequestMethod.GET)
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

  @RequestMapping(value = "/article")
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

  @RequestMapping(value = "/article/upload", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO markdownUploadImage(@RequestParam("editormd-image-file") MultipartFile file) {
    String url = aliyunOSSUtil.uploadFile(file, "");
    if (url != null) {
      return ResultUtil.success("图片上传成功", url);
    } else {
      return ResultUtil.error("图片上传失败", null);
    }
  }
}
