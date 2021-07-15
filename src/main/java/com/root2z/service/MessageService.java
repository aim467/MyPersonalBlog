package com.root2z.service;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Message;

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
}
