package com.root2z.service;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Friend;

public interface FriendService {

  /**
   * 统计友链数
   *
   * @return
   */
  int countFriend();

  PageInfo<Friend> pageQueryFriend(int pageNum, int pageSize);
}
