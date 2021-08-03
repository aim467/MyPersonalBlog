package com.root2z.dao;

import com.root2z.model.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Article article);

  int insertSelective(Article record);

  Article selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Article article);

  int updateByPrimaryKeyWithBLOBs(Article record);

  int updateByPrimaryKey(Article record);

  /**
   * 统计博文数
   *
   * @return
   */
  int totalCount();

  List<Article> findAll();

  int updateStatusByPrimaryKey(
      @Param("articleId") Integer articleId, @Param("status") Integer status);

  /**
   * 获取置顶的博客
   *
   * @param top
   * @return
   */
  List<Article> selectAllByTop(Integer top);

  /**
   * 根据文章的更新时间排序
   *
   * @return
   */
  List<Article> selectAllByUpdateTime();

  /**
   * 查询推荐文章
   *
   * @param recommendNumber
   * @return
   */
  List<Article> selectAllByRecommend(Integer recommendNumber);

  Article selectByArticleId(Integer articleId);

  /**
   * 获得发布文章的年份
   *
   * @return
   */
  List<String> getYears();

  /**
   * 根据年份查找对应的文章
   *
   * @param year
   * @return
   */
  List<Article> findByYear(@Param("year") String year);

  /**
   * 根据分类ID查询所有文章
   *
   * @param categoryId
   * @return
   */
  List<Article> selectAllCategoryId(Integer categoryId);
}
