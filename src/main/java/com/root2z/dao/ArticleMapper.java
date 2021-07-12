package com.root2z.dao;

import com.root2z.model.entity.Article;
import com.root2z.model.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(ArticleVO articleVO);

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
