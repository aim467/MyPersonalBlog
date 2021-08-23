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
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** @author root2z */
@Service
public class CommentServiceImpl implements CommentService {

  @Autowired private RedisTemplate redisTemplate;

  /** 保存要被删除的留言ID集合 */
  private List<Integer> commentIds = new ArrayList<>();

  private final CommentMapper commentMapper;

  /** 存放迭代找出的所有子代的集合 */
  private List<Comment> tempReplys = new ArrayList<>();

  @Autowired
  public CommentServiceImpl(CommentMapper commentMapper) {
    this.commentMapper = commentMapper;
  }

  /**
   * @Description: 查询评论 <br>
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
    redisTemplate.delete("newsComment");
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
    redisTemplate.delete("newsComment");
    // 先加上自己的ID
    commentIds.add(commentId);
    // 传入自己的ID，作为子评论的parent_id，查询数据
    recursionDelete(commentId);
    return commentMapper.deleteAllByIds(commentIds) > 0;
  }

  /**
   * 循环删除子评论
   *
   * @param Id
   * @return
   */
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
    List<Comment> newsCommentCache = (List<Comment>) redisTemplate.opsForValue().get("newsComment");
    if (newsCommentCache == null | StringUtils.isEmpty(newsCommentCache)) {
      List<Comment> comments = commentMapper.selectAllBySorted(limit);
      redisTemplate.opsForValue().set("newsComment", comments);
      return comments;
    }
    return newsCommentCache;
  }

  /**
   * 保存评论
   *
   * @param comment 评论对象
   * @return
   */
  @Override
  public ResultVO saveComment(Comment comment) {
    redisTemplate.delete("newsComment");
    String emptyAvatar = "";
    if (emptyAvatar.equals(comment.getAvatar())) {
      try {
        comment.setAvatar(RandomAvatar.getBase64Avatar());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (emptyAvatar.equals(comment.getCommentator()) || emptyAvatar.equals(comment.getContent())) {
      return ResultUtil.error("请填写正确的昵称和内容", null);
    }

    if (commentMapper.insertSelective(comment) < 0) {
      return ResultUtil.error("提交评论失败!", null);
    }
    return ResultUtil.success("提交评论成功", null);
  }
}
