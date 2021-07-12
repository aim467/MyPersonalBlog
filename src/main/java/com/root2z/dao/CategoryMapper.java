package com.root2z.dao;

import com.root2z.model.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
  /**
   * 根据ID删除分类
   *
   * @param id
   * @return
   */
  int deleteByPrimaryKey(Integer id);

  int insert(Category record);

  int insertSelective(Category record);

  Category selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Category record);

  int updateByPrimaryKey(Category record);

  Category selectByName(String name);

  /**
   * 统计分类数
   *
   * @return
   */
  int totalCount();

  /**
   * 查询所有的分类
   *
   * @return List<Category> 分类列表
   */
  List<Category> findAll();
}
