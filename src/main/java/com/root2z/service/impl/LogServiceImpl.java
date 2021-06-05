package com.root2z.service.impl;

import com.root2z.dao.LogMapper;
import com.root2z.model.entity.Log;
import com.root2z.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LogServiceImpl implements LogService {

  @Autowired private LogMapper logMapper;

  /**
   * 插入一条登录记录
   *
   * @param username
   */
  @Override
  public void addRecord(String username, String ipaddress) {
    Log log = new Log();
    log.setIpaddress(ipaddress);
    log.setUsername(username);
    log.setLoginTime(new Date());
    logMapper.insert(log);
  }

  @Override
  public int countLog() {
    return logMapper.totalCount();
  }
}
