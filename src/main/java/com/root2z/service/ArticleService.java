package com.root2z.service;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Article;
import com.root2z.model.vo.ArticleVO;

public interface ArticleService {

  /**
   * 文章统计
   *
   * @return
   */
  int countArticle();

  /**
   * 新增文章
   *
   * @param articleVO
   * @return
   */
  boolean addArticle(ArticleVO articleVO);

  boolean deleteArticle(Integer articleId);

  boolean editArticle(ArticleVO articleVO);

  /**
   * 拿到当前文章信息
   *
   * @param articleId
   * @return
   */
  ArticleVO getArticleInfo(Integer articleId);

  PageInfo<Article> pageQuery(Integer pageNum, Integer pageSize);

  boolean updateArticleStatus(Integer articleId, Integer status);
}
