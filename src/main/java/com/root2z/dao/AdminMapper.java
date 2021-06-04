package com.root2z.dao;

import com.root2z.model.entity.Admin;

public interface AdminMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(Admin record);

  int insertSelective(Admin record);

  Admin selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Admin record);

  int updateByPrimaryKey(Admin record);

  /**
   * 根据用户名查询用户，并且是查询已激活的
   *
   * @param userName
   * @return
   */
  Admin selectByUserNameAndPassword(String username, String password);
}
