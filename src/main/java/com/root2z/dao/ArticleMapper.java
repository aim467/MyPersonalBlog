package com.root2z.dao;

import com.root2z.model.entity.Article;

public interface ArticleMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Article record);

  int insertSelective(Article record);

  Article selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Article record);

  int updateByPrimaryKeyWithBLOBs(Article record);

  int updateByPrimaryKey(Article record);

  /**
   * 统计博文数
   *
   * @return
   */
  int totalCount();
}
