package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.dao.FriendMapper;
import com.root2z.model.entity.Friend;
import com.root2z.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

  private final FriendMapper friendMapper;

  @Autowired
  public FriendServiceImpl(FriendMapper friendMapper) {
    this.friendMapper = friendMapper;
  }

  @Override
  public int countFriend() {
    return friendMapper.totalCount();
  }

  @Override
  public PageInfo<Friend> pageQueryFriend(int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Friend> friendList = friendMapper.findAll();
    PageInfo pageInfo = new PageInfo<>(friendList);
    return pageInfo;
  }
}
