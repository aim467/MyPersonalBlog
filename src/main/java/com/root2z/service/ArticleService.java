package com.root2z.service;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Article;
import com.root2z.model.vo.ArticleVO;
import com.root2z.model.vo.FrontArticleVO;
import com.root2z.model.vo.ResultVO;

import java.util.List;
import java.util.Map;

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
  ResultVO addArticle(ArticleVO articleVO);

  boolean deleteArticle(Integer articleId);

  ResultVO editArticle(ArticleVO articleVO);

  /**
   * 拿到当前文章信息
   *
   * @param articleId
   * @return
   */
  ArticleVO getArticleInfo(Integer articleId);

  PageInfo<Article> pageQuery(Integer pageNum, Integer pageSize);

  boolean updateArticleStatus(Integer articleId, Integer status);

  /**
   * 获得置顶博客
   *
   * @return
   */
  List<Article> getTopArticle(Integer top);

  /**
   * 根据文章的更新时间排序，并且分页
   *
   * @return
   * @param pageNum
   * @param pageSize
   */
  PageInfo<Article> getArticleByTime(Integer pageNum, Integer pageSize);

  /**
   * 得到推荐文章
   *
   * @return
   */
  List<Article> getRecommendArticle(Integer recommendNumber);

  Article getArticleById(Integer articleId);

  /**
   * 获得归档文章
   *
   * @return
   */
  Map<String, List<Article>> getArchives();

  /**
   * 根据对应的分类ID拿到所有的文章数据并且进行分页
   *
   * @param categoryId
   * @param page
   * @param size
   * @return
   */
  PageInfo<Article> getAllByCategory(Integer categoryId, Integer page, Integer size);
}
