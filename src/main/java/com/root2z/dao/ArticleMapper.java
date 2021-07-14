package com.root2z.dao;

import com.root2z.model.entity.Article;
import com.root2z.model.vo.ArticleVO;
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

  int updateStatusByPrimaryKey(@Param("articleId") Integer articleId, @Param("status") Integer status);
}
