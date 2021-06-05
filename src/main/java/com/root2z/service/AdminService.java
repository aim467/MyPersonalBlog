package com.root2z.service;

import com.root2z.model.entity.Admin;

public interface AdminService {
  Admin login(String username, String password);

  /**
   * 用户统计
   *
   * @return
   */
  int countUser();

  /**
   * 根据用户ID更新密码
   *
   * @param ReNewPassword
   * @param loginUserId
   * @return
   */
  int updatePassword(String ReNewPassword, Integer loginUserId);
}
