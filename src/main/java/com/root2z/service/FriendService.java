package com.root2z.service;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Friend;

import java.util.List;

public interface FriendService {

  /**
   * 统计友链数
   *
   * @return int 返回友链个数
   */
  int countFriend();

  PageInfo<Friend> pageQueryFriend(int pageNum, int pageSize);

  boolean deleteFriendById(Integer id);

  boolean addFriend(Friend friend);

  /**
   * 根据ID查找到友情链接
   *
   * @param id
   * @return
   */
  Friend getFriendById(Integer id);

  boolean updateFriend(Friend friend);

  List<Friend> listFriends();
}
