package com.root2z.dao;

import com.root2z.model.entity.Friend;

import java.util.List;

public interface FriendMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Friend record);

  int insertSelective(Friend record);

  Friend selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Friend record);

  int updateByPrimaryKey(Friend record);

  /**
   * 统计友链数
   *
   * @return
   */
  int totalCount();

  /**
   * 查找所有的友情链接
   *
   * @return
   */
  List<Friend> findAll();
}
