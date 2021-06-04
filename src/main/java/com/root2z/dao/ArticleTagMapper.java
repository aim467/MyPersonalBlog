package com.root2z.dao;

import com.root2z.model.entity.ArticleTag;
import org.apache.ibatis.annotations.Param;

public interface ArticleTagMapper {
    int deleteByPrimaryKey(@Param("articleId") Integer articleId, @Param("tagId") Integer tagId);

    int insert(ArticleTag record);

    int insertSelective(ArticleTag record);
}