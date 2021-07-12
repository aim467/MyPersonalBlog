package com.root2z.dao;

import com.root2z.model.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Mapper
public interface TagMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(@Param("name") String name) throws DataAccessException;

  int insertSelective(Tag record);

  Tag selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Tag record);

  int updateByPrimaryKey(Tag record);

  /**
   * 标签统计
   *
   * @return
   */
  int totalCount();

  /**
   * 找到所有的标签记录
   *
   * @return List<Tag>
   */
  List<Tag> findAll();

  /**
   * 批量插入标签，同时返回插入的标签ID
   *
   * @param tags 多个标签列表
   */
  void batchInsert(List<Tag> tags);

  Tag selectByName(Tag tag);
  
  int insertByName(Tag tag);
}
