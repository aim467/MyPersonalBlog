package com.root2z.dao;

import com.root2z.model.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Message record);

  int insertSelective(Message record);

  Message selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Message record);

  int updateByPrimaryKey(Message record);

  /**
   * 留言统计
   *
   * @return
   */
  int totalCount();

  List<Message> findAll();

  List<Message> findAllById(@Param("id") Integer id);

  /**
   * 逻辑删除留言
   *
   * @param Ids 要删除的留言ID列表
   * @return
   */
  int deleteAllById(@Param("Ids") List<Integer> Ids);
}
