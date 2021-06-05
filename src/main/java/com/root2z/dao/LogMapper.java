package com.root2z.dao;

import com.root2z.model.entity.Log;

public interface LogMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Log record);

  int insertSelective(Log record);

  Log selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Log record);

  int updateByPrimaryKey(Log record);

  /**
   * 日志统计
   *
   * @return
   */
  int totalCount();
}
