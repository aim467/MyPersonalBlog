package com.root2z.dao;

import com.root2z.model.entity.ArticleCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleCategoryMapper {
    int deleteByPrimaryKey(@Param("articleId") Integer articleId, @Param("categoryId") Integer categoryId);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    int deleteByArticleId(@Param("articleId") Integer articleId);
}