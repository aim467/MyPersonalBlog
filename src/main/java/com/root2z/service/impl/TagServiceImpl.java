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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/** @author root2z */
@Service
public class TagServiceImpl implements TagService {
  private final RedisTemplate redisTemplate;

  private final Logger logger = LoggerFactory.getLogger(TagServiceImpl.class);

  private final TagMapper tagMapper;

  @Autowired
  public TagServiceImpl(TagMapper tagMapper, RedisTemplate redisTemplate) {
    this.tagMapper = tagMapper;
    this.redisTemplate = redisTemplate;
  }

  @Override
  public int countTag() {
    return tagMapper.totalCount();
  }

  /**
   * 实现标签分页
   *
   * @param pageNum 页码
   * @param pageSize 页大小
   * @return 分页结果
   */
  @Override
  public PageInfo<Tag> pageQueryTag(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Tag> tagList = tagMapper.findAll();
    return new PageInfo<>(tagList);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public boolean deleteTag(Integer id) {
    try {
      return tagMapper.deleteTagAndArticleTagById(id) > 0;
    } catch (Exception e) {
      throw e;
    }
  }

  @Override
  public boolean addTag(String name) {
    redisTemplate.delete("tagCount");
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
    redisTemplate.delete("tagCount");
    return tagMapper.updateByPrimaryKeySelective(tag) == 1;
  }

  @Override
  public List<Tag> getAllTags() {
    return tagMapper.findAll();
  }

  /**
   * 根据每个标签统计文章数量
   *
   * @return 统计结果
   */
  @Override
  public List<Tag> getTagCount() {
    List<Tag> tagCount = (List<Tag>) redisTemplate.opsForValue().get("tagCount");
    if (tagCount == null || StringUtils.isEmpty(tagCount)) {
      List<Tag> tagList = tagMapper.selectAllByCount();
      redisTemplate.opsForValue().set("tagCount", tagList);
      return tagList;
    }
    return tagCount;
  }

  @Override
  public Integer getTagId() {
    return tagMapper.selectId();
  }
}
