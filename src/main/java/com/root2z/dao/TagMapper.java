package com.root2z.dao;

import com.root2z.model.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(@Param("name") String name);

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
}
