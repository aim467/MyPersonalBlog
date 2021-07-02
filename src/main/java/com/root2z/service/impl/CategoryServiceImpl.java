package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.dao.AdminMapper;
import com.root2z.dao.CategoryMapper;
import com.root2z.model.entity.Category;
import com.root2z.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

  private final CategoryMapper categoryMapper;

  @Autowired
  public CategoryServiceImpl(CategoryMapper categoryMapper) {
    this.categoryMapper = categoryMapper;
  }

  @Override
  public int countCategory() {
    return categoryMapper.totalCount();
  }

  /**
   * 返回分页后的分类列表
   *
   * @param pageNum 当前页码
   * @param pageSize 当前页面大小
   * @return PageInfo<Category> 分页后的分类列表
   */
  @Override
  public PageInfo<Category> pageQueryCategory(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Category> categories = categoryMapper.findAll();
    return new PageInfo<Category>(categories);
  }

  /**
   * 新增分类
   *
   * @param category 分类Bean
   * @return 是否插入成功标志
   */
  @Override
  public boolean addCategory(Category category) {
    return categoryMapper.insert(category) == 1;
  }

  /**
   * 删除分类 根据ID删除分类
   *
   * @param id 分类ID
   * @return 是否删除成功标志
   */
  @Override
  public boolean deleteCategoryById(Integer id) {
    return categoryMapper.deleteByPrimaryKey(id) == 1;
  }

  /**
   * 更新分类
   *
   * @param category 分类
   * @return 是否更新分类成功标志
   */
  @Override
  public boolean updateCategoryById(Category category) {
    return categoryMapper.updateByPrimaryKey(category) == 1;
  }
}
