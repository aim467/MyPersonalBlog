package com.root2z.service.impl;

import com.root2z.dao.FriendMapper;
import com.root2z.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
