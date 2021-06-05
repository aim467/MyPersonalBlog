package com.root2z.service.impl;

import com.root2z.dao.MessageMapper;
import com.root2z.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

  private final MessageMapper messageMapper;

  @Autowired
  public MessageServiceImpl(MessageMapper messageMapper) {
    this.messageMapper = messageMapper;
  }

  @Override
  public int countMessage() {
    return messageMapper.totalCount();
  }
}
