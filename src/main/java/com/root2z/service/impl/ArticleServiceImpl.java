package com.root2z.service.impl;

import com.root2z.dao.*;
import com.root2z.model.entity.ArticleCategory;
import com.root2z.model.entity.ArticleTag;
import com.root2z.model.entity.Category;
import com.root2z.model.entity.Tag;
import com.root2z.model.vo.ArticleVO;
import com.root2z.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    // 插入文章，同时返回插入文章的ID
    if (articleMapper.insert(articleVO) == 0) {
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
            articleTagMapper.insert(new ArticleTag(articleVO.getId(), existingTag.getId()));

          } else {
            // 插入的同时获得主键ID
            tagMapper.insertByName(tag);
            articleTagMapper.insert(new ArticleTag(articleVO.getId(), tag.getId()));
          }
        });

    // 收尾工作，插入文章和分类的关联表
    Category category = categoryMapper.selectByName(articleVO.getCategory());
    ArticleCategory articleCategory = new ArticleCategory();
    articleCategory.setCategoryId(category.getId());
    articleCategory.setArticleId(articleVO.getId());

    if (articleCategoryMapper.insert(articleCategory) == 0) {
      return false;
    }
    return true;
  }

}
