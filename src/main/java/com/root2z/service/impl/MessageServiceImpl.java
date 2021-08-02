package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.config.BlogConst;
import com.root2z.dao.MessageMapper;
import com.root2z.model.entity.Message;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.MessageService;
import com.root2z.utils.RandomAvatar;
import com.root2z.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

  private final MessageMapper messageMapper;

  /** 保存要被删除的留言ID集合 */
  private List<Integer> messageIds = new ArrayList<>();

  /** 所有子回复集合 */
  private List<Message> tempReplys = new ArrayList<>();

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

  /** @Description: 查询评论 @Auther: ONESTAR @Date: 17:26 2020/4/14 @Param: @Return: 评论消息 */
  @Override
  public List<Message> listMessage() {
    // 查询出父节点
    List<Message> messages = messageMapper.findByParentIdNull(-1);
    for (Message message : messages) {
      int id = message.getId();
      String parentNickname1 = message.getAuthor();
      List<Message> childMessages = messageMapper.findByParentIdNotNull(id);
      // 查询出子评论
      combineChildren(childMessages, parentNickname1);
      message.setReplyMessages(tempReplys);
      tempReplys = new ArrayList<>();
    }
    return messages;
  }

  @Override
  public ResultVO addMessage(Message message) {
    if (message.getAvatar().equals("")) {
      try {
        message.setAvatar(RandomAvatar.getBase64Avatar());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (message.getAuthor().equals("") || message.getContent().equals("")) {
      return ResultUtil.error("请填写正确的昵称和内容", null);
    }

    if (messageMapper.insertSelective(message) < 0) {
      return ResultUtil.error("提交留言失败!", null);
    }
    return ResultUtil.success("提交留言成功", null);
  }

  /**
   * @Description: 查询出子评论 @Auther: ONESTAR @Date: 17:31 2020/4/14 @Param:
   * childComments：所有子评论 @Param: parentNickname1：父评论的姓名 @Return:
   */
  private void combineChildren(List<Message> childMessages, String parentNickname1) {
    // 判断是否有一级子回复
    if (childMessages.size() > 0) {
      // 循环找出子评论的id
      for (Message childMessage : childMessages) {
        String parentNickname = childMessage.getAuthor();
        childMessage.setParentNickname(parentNickname1);
        tempReplys.add(childMessage);
        int childId = childMessage.getId();
        // 查询二级以及所有子集回复
        recursively(childId, parentNickname);
      }
    }
  }

  /**
   * @Description: 循环迭代找出子集回复 @Auther: ONESTAR @Date: 17:33 2020/4/14 @Param: childId：子评论的id @Param:
   * parentNickname1：子评论的姓名 @Return:
   */
  private void recursively(int childId, String parentNickname1) {
    // 根据子一级评论的id找到子二级评论
    List<Message> replayMessages = messageMapper.findByReplayId(childId);

    if (replayMessages.size() > 0) {
      for (Message replayMessage : replayMessages) {
        String parentNickname = replayMessage.getAuthor();
        replayMessage.setParentNickname(parentNickname1);
        int replayId = replayMessage.getId();
        tempReplys.add(replayMessage);
        // 循环迭代找出子集回复
        recursively(replayId, parentNickname);
      }
    }
  }
}
