package com.root2z.service;

import com.root2z.model.entity.Admin;
import com.root2z.model.vo.AdminVO;

public interface AdminService {
  Admin login(String username, String password);

  /**
   * 用户统计
   *
   * @return
   */
  int countUser();

  /**
   * 根据用户名更新密码
   *
   * @param ReNewPassword
   * @param username
   * @return
   */
  int updatePassword(String ReNewPassword, String username);

  /**
   * 获取当前用户
   *
   * @param loginUser
   * @return
   */
  AdminVO getCurrentUser(String loginUser);

  /**
   * 更新当前管理员信息
   *
   * @param adminVO
   * @return
   */
  int updateAdmin(AdminVO adminVO);
}
