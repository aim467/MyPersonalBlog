package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.dao.*;
import com.root2z.model.entity.*;
import com.root2z.model.vo.ArticleVO;
import com.root2z.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

  private final HttpServletRequest request;

  private final ArticleMapper articleMapper;

  private final CategoryMapper categoryMapper;

  private final TagMapper tagMapper;

  private final ArticleCategoryMapper articleCategoryMapper;

  @Autowired private ArticleTagMapper articleTagMapper;

  private Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

  @Autowired
  public ArticleServiceImpl(
      ArticleMapper articleMapper,
      CategoryMapper categoryMapper,
      TagMapper tagMapper,
      HttpServletRequest request,
      ArticleCategoryMapper articleCategoryMapper) {
    this.articleMapper = articleMapper;
    this.tagMapper = tagMapper;
    this.categoryMapper = categoryMapper;
    this.request = request;
    this.articleCategoryMapper = articleCategoryMapper;
  }

  @Override
  public int countArticle() {
    return articleMapper.totalCount();
  }

  /**
   * 保存文章 保存ArticleCategory表 保存ArticleTag表
   *
   * @param articleVO 文章View Object
   * @return 保存标志
   */
  @Override
  public boolean addArticle(ArticleVO articleVO) {
    // 保存文章时，手动设置发布时间和更新时间为当前时间
    articleVO.setPublishTime(new Date());
    articleVO.setUpdateTime(new Date());
    // 设置当前发布文章的作者
    HttpSession session = request.getSession();
    articleVO.setAuthor((String) session.getAttribute("nickName"));

    // POJO与VO转换
    Article article = new Article();
    BeanUtils.copyProperties(articleVO, article);

    // 插入文章，同时返回插入文章的ID
    if (articleMapper.insert(article) == 0) {
      return false;
    }

    // 中间工作，插入分类
    // 设置新插入的分类列表
    List<Tag> tags = new ArrayList<>();
    for (String name : articleVO.getTags()) {
      Tag tag = new Tag();
      tag.setName(name);
      tags.add(tag);
    }

    // 插入tag表和articleTag表
    tags.forEach(
        tag -> {
          // 遍历每一个tag，确认是否存在
          // 查到tag，有记录，没查到，没有记录
          Tag existingTag = tagMapper.selectByName(tag);

          // 说明存在tag
          if (existingTag != null) {
            // 往articleTag表插入关联对象
            articleTagMapper.insert(new ArticleTag(article.getId(), existingTag.getId()));
          } else {
            // 插入的同时获得主键ID
            tagMapper.insertByName(tag);
            articleTagMapper.insert(new ArticleTag(article.getId(), tag.getId()));
          }
        });

    // 收尾工作，插入文章和分类的关联表
    Category category = categoryMapper.selectByName(articleVO.getCategory());
    ArticleCategory articleCategory = new ArticleCategory();
    articleCategory.setCategoryId(category.getId());
    articleCategory.setArticleId(article.getId());

    if (articleCategoryMapper.insert(articleCategory) == 0) {
      return false;
    }
    return true;
  }

  /**
   * 删除文章表，删除articleTag表，删除articleCategory表
   *
   * @param articleId
   * @return
   */
  @Override
  public boolean deleteArticle(Integer articleId) {
    // 删除文章表
    if (articleMapper.deleteByPrimaryKey(articleId) == 0) {
      return false;
    }
    // 删除文章标签表
    if (articleTagMapper.deleteByArticleId(articleId) == 0) {
      return false;
    }
    // 删除文章分类表
    if (articleCategoryMapper.deleteByArticleId(articleId) == 0) {
      return false;
    }
    return true;
  }

  /**
   * 获得文章信息
   *
   * @param articleVO 文章视图层对象
   * @return
   */
  @Override
  public boolean editArticle(ArticleVO articleVO) {
    // 拿到当前登录用户
    HttpSession session = request.getSession();
    articleVO.setAuthor((String) session.getAttribute("nickName"));
    // 只需要设置更新时间
    articleVO.setPublishTime(new Date());

    Article article = new Article();
    BeanUtils.copyProperties(articleVO, article);

    // 更新文章，不会更新ID，这时直接就有ID
    if (articleMapper.updateByPrimaryKeySelective(article) == 0) {
      return false;
    }

    // 中间工作，插入分类
    // 设置新插入的分类列表
    List<Tag> tags = new ArrayList<>();
    for (String name : articleVO.getTags()) {
      Tag tag = new Tag();
      tag.setName(name);
      tags.add(tag);
    }

    // 插入tag表和articleTag表
    tags.forEach(
        tag -> {
          // 遍历每一个tag，确认是否存在
          // 查到tag，有记录，没查到，没有记录
          Tag existingTag = tagMapper.selectByName(tag);

          // 说明 tag 不存在
          if (existingTag == null) {
            // 插入的同时获得主键ID
            tagMapper.insertByName(tag);
            articleTagMapper.insert(new ArticleTag(article.getId(), tag.getId()));
            // 说明存在tag
          } else {

            // 只有在articleTag表里面article_id和tag_id不存在时才可以插入
            if (articleTagMapper.selectByAll(article.getId(), existingTag.getId()) != null) {
              ;
            } else {
              // 往articleTag表插入关联对象
              // 这里更新的时候存在重复插入了
              articleTagMapper.insert(new ArticleTag(article.getId(), existingTag.getId()));
            }
          }
        });

    // 拿到分类对象
    Category category = categoryMapper.selectByName(articleVO.getCategory());
    ArticleCategory articleCategory = new ArticleCategory();

    // 重新关联文章分类表
    articleCategory.setArticleId(article.getId());
    articleCategory.setCategoryId(category.getId());

    if (articleCategoryMapper.selectByAll(
            articleCategory.getArticleId(), articleCategory.getCategoryId())
        != null) {
      ;
    } else {
      if (articleCategoryMapper.insert(articleCategory) == 0) {
        return false;
      }
    }

    return true;
  }

  @Override
  public ArticleVO getArticleInfo(Integer articleId) {
    ArticleVO articleVO = new ArticleVO();
    // 拿到文章对象
    Article article = articleMapper.selectByPrimaryKey(articleId);
    BeanUtils.copyProperties(article, articleVO);

    // 设置分类
    Category category = categoryMapper.selectByArticleId(articleId);
    articleVO.setCategory(category.getName());

    // 设置标签
    List<String> tags = tagMapper.selectNameByArticleId(articleId);
    articleVO.setTags(tags);
    return articleVO;
  }

  /**
   * 文章分页查询
   *
   * @param pageNum
   * @param pageSize
   * @return
   */
  @Override
  public PageInfo<Article> pageQuery(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Article> articles = articleMapper.findAll();
    return new PageInfo<Article>(articles);
  }

  /**
   * 更新文章状态
   *
   * @param articleId
   * @param status
   * @return
   */
  @Override
  public boolean updateArticleStatus(Integer articleId, Integer status) {
    return articleMapper.updateStatusByPrimaryKey(articleId, status) == 1;
  }
}
