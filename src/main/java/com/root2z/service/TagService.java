package com.root2z.service;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Tag;

public interface TagService {

  /**
   * 统计标签数
   *
   * @return
   */
  int countTag();

  /**
   * 标签分页
   *
   * @param pageNum
   * @param pageSize
   * @return
   */
  PageInfo<Tag> PageQueryTag(int pageNum, int pageSize);

  /**
   * 根据ID删除标签
   *
   * @param id
   * @return
   */
  boolean deleteTag(Integer id);


  Tag getTagById(Integer id);

  /**
   * 添加一个tag
   *
   * @param name
   * @return
   */
  boolean addTag(String name);


  /**
   * 更新Tag
   * @param tag
   * @return
   */
  boolean updateTag(Tag tag);

}