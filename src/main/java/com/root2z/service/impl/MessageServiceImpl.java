package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.config.BlogConst;
import com.root2z.dao.MessageMapper;
import com.root2z.model.entity.Message;
import com.root2z.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

  private final MessageMapper messageMapper;

  /** 保存要被删除的留言ID集合 */
  private List<Integer> messageIds = new ArrayList<>();

  @Autowired
  public MessageServiceImpl(MessageMapper messageMapper) {
    this.messageMapper = messageMapper;
  }

  @Override
  public int countMessage() {
    return messageMapper.totalCount();
  }

  @Override
  public PageInfo<Message> pageQueryMessages(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Message> messageList = messageMapper.findAll();
    return new PageInfo<Message>(messageList);
  }

  /**
   * 插入一条留言
   *
   * @param message
   * @return
   */
  @Override
  public boolean insertMessage(Message message) {
    message.setCreateTime(new Date());
    message.setAuthor(BlogConst.nickName);
    message.setAvatar(BlogConst.avatar);
    message.setEmail(BlogConst.email);
    message.setUrl(BlogConst.url);
    return messageMapper.insertSelective(message) == 1;
  }

  /**
   * 删除评论 删除顶级评论，要删除一级和二级评论 删除二级评论，要删除二级评论
   *
   * @param messageId
   * @return
   */
  @Override
  public boolean deleteMessage(Integer messageId) {
    // 先加上自己的ID，因为自己也要删除
    messageIds.add(messageId);
    // 然后传入自己的ID递归查询子回复
    recursionDelete(messageId);
    System.out.println(messageIds);
    //    return false;
    return messageMapper.deleteAllById(messageIds) > 0;
  }

  /**
   * 递归删除
   *
   * @param Id
   * @return
   */
  private boolean recursionDelete(Integer Id) {
    // 先拿到第一个评论的子评论
    List<Message> messages = messageMapper.findAllById(Id);
    if (messages.size() == 0) {
      return false;
    }

    for (Message message : messages) {
      Integer messageId = message.getId();
      messageIds.add(messageId);
      recursionDelete(messageId);
    }
    return false;
  }
}
