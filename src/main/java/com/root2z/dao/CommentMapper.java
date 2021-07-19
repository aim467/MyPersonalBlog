package com.root2z.dao;

import com.root2z.model.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Comment record);

  int insertSelective(Comment record);

  Comment selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Comment record);

  int updateByPrimaryKey(Comment record);

  /**
   * 统计评论数
   *
   * @return
   */
  int totalCount();

  List<Comment> findAll();

  /**
   * 根据主键查序这个子数据
   *
   * @param commentId
   * @return
   */
  List<Comment> findAllById(@Param("commentId") Integer commentId);

  int deleteAllByIds(@Param("Ids") List<Integer> ids);
}
