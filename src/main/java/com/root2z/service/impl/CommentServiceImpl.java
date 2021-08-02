package com.root2z.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.root2z.config.BlogConst;
import com.root2z.dao.CommentMapper;
import com.root2z.model.entity.Comment;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.CommentService;
import com.root2z.utils.RandomAvatar;
import com.root2z.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

  /** 保存要被删除的留言ID集合 */
  private List<Integer> commentIds = new ArrayList<>();

  private final CommentMapper commentMapper;

  // 存放迭代找出的所有子代的集合
  private List<Comment> tempReplys = new ArrayList<>();

  @Autowired
  public CommentServiceImpl(CommentMapper commentMapper) {
    this.commentMapper = commentMapper;
  }

  /**
   * @Description: 查询评论 <br>
   * @Auther: ONESTAR <br>
   * @Date: 17:26 2020/4/14 <br>
   * @Param: <br>
   * @Return: 评论消息 <br>
   */
  @Override
  public List<Comment> listComment(Integer articleId) {
    // 查询出父节点
    List<Comment> comments = commentMapper.findByParentIdNull(-1, articleId);
    for (Comment comment : comments) {
      int id = comment.getId();
      String parentNickname1 = comment.getCommentator();
      List<Comment> childComments = commentMapper.findByParentIdNotNull(id, articleId);
      // 查询出子评论
      combineChildren(childComments, parentNickname1, articleId);
      comment.setReplyComments(tempReplys);
      tempReplys = new ArrayList<>();
    }
    return comments;
  }
  /**
   * @Description: 查询出子评论 <br>
   * @Param: childComments：所有子评论 <br>
   * @Param: parentNickname1：父评论的姓名 <br>
   */
  private void combineChildren(List<Comment> childComments, String parentNickname1, int articleId) {
    // 判断是否有一级子回复
    if (childComments.size() > 0) {
      // 循环找出子评论的id
      for (Comment childComment : childComments) {
        String parentNickname = childComment.getCommentator();
        childComment.setParentNickname(parentNickname1);
        tempReplys.add(childComment);
        int childId = childComment.getId();
        // 查询二级以及所有子集回复
        recursively(childId, parentNickname, articleId);
      }
    }
  }

  /**
   * 循环迭代找出子集回复 <br>
   * @Param childId：子评论的id <br>
   * @Param parentNickname1：子评论的姓名 <br>
   */
  private void recursively(int childId, String parentNickname1, int articleId) {
    // 根据子一级评论的id找到子二级评论
    List<Comment> replayComments = commentMapper.findByReplayId(childId, articleId);
    if (replayComments.size() > 0) {
      for (Comment replayComment : replayComments) {
        String parentNickname = replayComment.getCommentator();
        replayComment.setParentNickname(parentNickname1);
        int replayId = replayComment.getId();
        tempReplys.add(replayComment);
        // 循环迭代找出子集回复
        recursively(replayId, parentNickname, articleId);
      }
    }
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

  @Override
  public List<Comment> getNewComments(Integer limit) {
    return commentMapper.selectAllBySorted(limit);
  }

  @Override
  public ResultVO saveComment(Comment comment) {
    if (comment.getAvatar().equals("")) {
      try {
        comment.setAvatar(RandomAvatar.getBase64Avatar());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    if (comment.getCommentator().equals("") || comment.getContent().equals("")) {
      return ResultUtil.error("请填写正确的昵称和内容", null);
    }

    if (commentMapper.insertSelective(comment) < 0) {
      return ResultUtil.error("提交评论失败!", null);
    }
    return ResultUtil.success("提交评论成功", null);
  }
}
