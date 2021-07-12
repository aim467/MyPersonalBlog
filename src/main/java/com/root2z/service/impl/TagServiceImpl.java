package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.dao.TagMapper;
import com.root2z.model.entity.Tag;
import com.root2z.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

  private Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);

  private final TagMapper tagMapper;

  @Autowired
  public TagServiceImpl(TagMapper tagMapper) {
    this.tagMapper = tagMapper;
  }

  @Override
  public int countTag() {
    return tagMapper.totalCount();
  }

  /**
   * 实现标签分页
   *
   * @param pageNum
   * @param pageSize
   * @return
   */
  @Override
  public PageInfo<Tag> PageQueryTag(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Tag> tagList = tagMapper.findAll();
    return new PageInfo<Tag>(tagList);
  }

  @Override
  public boolean deleteTag(Integer id) {
    return tagMapper.deleteByPrimaryKey(id) == 1;
  }

  @Override
  public Tag getTagById(Integer id) {
    return null;
  }

  @Override
  public boolean addTag(String name) {
    try {
      int result = tagMapper.insert(name);
      return result == 1;

    } catch (DataAccessException exception) {
      logger.info(exception.getMessage());
    }
    return false;
  }

  @Override
  public boolean updateTag(Tag tag) {
    return tagMapper.updateByPrimaryKeySelective(tag) == 1;
  }

  @Override
  public List<Tag> getAllTags() {
    return tagMapper.findAll();
  }
}
