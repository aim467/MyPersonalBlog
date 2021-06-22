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
    // 第二次分页就无效了
    List<Friend> friendList = friendMapper.findAll();
    return new PageInfo<Friend>(friendList);
  }

  /**
   * 根据友链ID删除友链
   *
   * @param id
   * @return
   */
  @Override
  public boolean deleteFriendById(Integer id) {
    return friendMapper.deleteByPrimaryKey(id) == 1;
  }

  /**
   * 插入一条友情链接记录
   *
   * @param friend
   * @return
   */
  @Override
  public boolean addFriend(Friend friend) {
    return friendMapper.insertSelective(friend) == 1;
  }

  /**
   * 根据友情链接找到ID
   *
   * @param id
   * @return
   */
  @Override
  public Friend getFriendById(Integer id) {
    return friendMapper.selectByPrimaryKey(id);
  }

  @Override
  public boolean updateFriend(Friend friend) {
    return friendMapper.updateByPrimaryKey(friend) == 1;
  }
}
