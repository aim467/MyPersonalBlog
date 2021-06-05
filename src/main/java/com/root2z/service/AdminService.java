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
}
