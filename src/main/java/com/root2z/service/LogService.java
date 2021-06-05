package com.root2z.service;

public interface LogService {

  /**
   * 插入一条登录记录
   *
   * @param username
   */
  void addRecord(String username, String ipaddress);

  /**
   * 统计日志数
   *
   * @return
   */
  int countLog();
}
