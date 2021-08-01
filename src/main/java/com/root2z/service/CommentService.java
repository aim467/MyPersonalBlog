package com.root2z.service;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Comment;

import java.util.List;

public interface CommentService {

  /**
   * 评论统计
   *
   * @return
   */
  int countComment();

  PageInfo<Comment> pageQueryComment(Integer pageNum, Integer pageSize);

  /**
   * 回复评论
   *
   * @param comment
   * @return
   */
  boolean replyComment(Comment comment);

  /**
   * 逻辑删除评论
   *
   * @return
   */
  boolean deleteComment(Integer commentId);

  /**
   * 获得最新的评论
   *
   * @param limit
   * @return
   */
  List<Comment> getNewComments(Integer limit);
}
