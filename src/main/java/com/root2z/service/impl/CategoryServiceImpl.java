package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.dao.CategoryMapper;
import com.root2z.model.entity.Category;
import com.root2z.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/** @author root2z */
@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired private CategoryMapper categoryMapper;

  @Autowired private RedisTemplate redisTemplate;

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
    return new PageInfo<>(categories);
  }

  /**
   * 新增分类
   *
   * @param category 分类Bean
   * @return 是否插入成功标志
   */
  @Override
  public boolean addCategory(Category category) {
    redisTemplate.delete("categoryCount");
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
    redisTemplate.delete("categoryCount");
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
    redisTemplate.delete("categoryCount");
    return categoryMapper.updateByPrimaryKey(category) == 1;
  }

  @Override
  public List<Category> getAllCategories() {
    return categoryMapper.findAll();
  }

  /** 根据博客统计分类数 */
  @Override
  public List<Category> getCategoryCount() {
    List<Category> categories = (List<Category>) redisTemplate.opsForValue().get("categoryCount");
    // 如果没从缓存中读到
    if (categories == null || StringUtils.isEmpty(categories)) {
      List<Category> categoryList = categoryMapper.selectAllAndCount();
      redisTemplate.opsForValue().set("categoryCount", categoryList);
    }
    return categories;
  }

  @Override
  public Integer getCategoryId() {
    return categoryMapper.selectByFirst();
  }
}
