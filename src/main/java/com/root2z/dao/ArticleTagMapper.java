package com.root2z.dao;

import com.root2z.model.entity.ArticleTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleTagMapper {
  int deleteByPrimaryKey(@Param("articleId") Integer articleId, @Param("tagId") Integer tagId);

  int insert(ArticleTag record);

  int insertSelective(ArticleTag record);

  /**
   * 根据文章ID删除关联标签
   *
   * @param articleId
   * @return
   */
  int deleteByArticleId(@Param("articleId") Integer articleId);

  /**
   * 通过两个数据判断行是否存在
   *
   * @param articleId
   * @param tagId
   * @return
   */
  ArticleTag selectByAll(@Param("articleId") Integer articleId, @Param("tagId") Integer tagId);
}
