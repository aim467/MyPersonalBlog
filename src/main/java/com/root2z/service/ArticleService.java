package com.root2z.service;

import com.root2z.model.entity.Article;
import com.root2z.model.entity.ArticleCategory;
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

  ArticleVO getArticleInfo(Integer articleId);
}
