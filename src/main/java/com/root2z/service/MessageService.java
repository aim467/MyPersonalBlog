package com.root2z.service;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Comment;
import com.root2z.model.entity.Message;
import com.root2z.model.vo.ResultVO;

import java.util.List;

public interface MessageService {

  /**
   * 统计留言数
   *
   * @return
   */
  int countMessage();

  PageInfo<Message> pageQueryMessages(Integer pageNum, Integer pageSize);

  boolean insertMessage(Message message);

  boolean deleteMessage(Integer messageId);

  /**
   * 找出所有的留言
   *
   * @return
   */
  List<Message> listMessage();

  /**
   * 添加留言
   *
   * @param message
   * @return
   */
  ResultVO addMessage(Message message);
}
