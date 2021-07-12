package com.root2z.service;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Category;

import java.util.List;

public interface CategoryService {

  /**
   * 分类统计
   *
   * @return
   */
  int countCategory();

  /**
   * 分页查询分类
   *
   * @param pageNum 当前页码
   * @param pageSize 当前页面大小
   * @return PageInfo<Category> 分页后的分类列表
   */
  PageInfo<Category> pageQueryCategory(int pageNum, int pageSize);

  /**
   * 新增一个分类
   *
   * @param category 分类Bean
   * @return
   */
  boolean addCategory(Category category);

  /**
   * 根据ID删除分类
   *
   * @param id
   * @return
   */
  boolean deleteCategoryById(Integer id);

  /**
   * 根据分类对象里的id来更新分类
   *
   * @param category
   * @return
   */
  boolean updateCategoryById(Category category);

  /**
   * 拿到所有的分类
   *
   * @return
   */
  List<Category> getAllCategories();
}
