package com.root2z.service.impl;

import com.root2z.dao.AdminMapper;
import com.root2z.model.entity.Admin;
import com.root2z.service.AdminService;
import com.root2z.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

  private final AdminMapper adminMapper;

  @Autowired
  public AdminServiceImpl(AdminMapper adminMapper) {
    this.adminMapper = adminMapper;
  }

  @Override
  public Admin login(String username, String password) {
    String passwordHash = MD5Utils.MD5Encode(password, "");
    return adminMapper.selectByUserNameAndPassword(username, passwordHash);
  }

  @Override
  public int countUser() {
    return adminMapper.totalCount();
  }
}
