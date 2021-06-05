package com.root2z.service.impl;

import com.root2z.dao.CommentMapper;
import com.root2z.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

  private final CommentMapper commentMapper;

  @Autowired
  public CommentServiceImpl(CommentMapper commentMapper) {
    this.commentMapper = commentMapper;
  }

  @Override
  public int countComment() {
    return commentMapper.totalCount();
  }
}
