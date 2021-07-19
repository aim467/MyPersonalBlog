package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.config.BlogConst;
import com.root2z.dao.CommentMapper;
import com.root2z.model.entity.Comment;
import com.root2z.model.entity.Message;
import com.root2z.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

  /** 保存要被删除的留言ID集合 */
  private List<Integer> commentIds = new ArrayList<>();

  private final CommentMapper commentMapper;

  @Autowired
  public CommentServiceImpl(CommentMapper commentMapper) {
    this.commentMapper = commentMapper;
  }

  @Override
  public int countComment() {
    return commentMapper.totalCount();
  }

  @Override
  public PageInfo<Comment> pageQueryComment(Integer pageNum, Integer pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<Comment> comments = commentMapper.findAll();
    return new PageInfo<>(comments);
  }

  @Override
  public boolean replyComment(Comment comment) {
    comment.setAvatar(BlogConst.avatar);
    comment.setEmail(BlogConst.email);
    return commentMapper.insertSelective(comment) > 0;
  }

  /**
   * 根据评论ID来删除
   *
   * @return
   */
  @Override
  public boolean deleteComment(Integer commentId) {
    // 先加上自己的ID
    commentIds.add(commentId);
    // 传入自己的ID，作为子评论的parent_id，查询数据
    recursionDelete(commentId);
    return commentMapper.deleteAllByIds(commentIds) > 0;
  }

  private boolean recursionDelete(Integer Id) {
    // 先拿到第一个评论的子评论
    List<Comment> comments = commentMapper.findAllById(Id);
    if (comments.size() == 0) {
      return false;
    }

    for (Comment comment : comments) {
      Integer commentId = comment.getId();
      commentIds.add(commentId);
      recursionDelete(commentId);
    }
    return false;
  }
}
