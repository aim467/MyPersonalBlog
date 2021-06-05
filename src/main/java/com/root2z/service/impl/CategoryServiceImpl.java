package com.root2z.service.impl;

import com.root2z.dao.AdminMapper;
import com.root2z.dao.CategoryMapper;
import com.root2z.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
