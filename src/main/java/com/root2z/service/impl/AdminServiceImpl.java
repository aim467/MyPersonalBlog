package com.root2z.service.impl;

import com.root2z.dao.AdminMapper;
import com.root2z.model.entity.Admin;
import com.root2z.model.vo.AdminVO;
import com.root2z.model.vo.LoginUserVO;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.AdminService;
import com.root2z.service.LogService;
import com.root2z.utils.IPUtils;
import com.root2z.utils.MD5Utils;
import com.root2z.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

  private final AdminMapper adminMapper;

  private final LogService logService;

  @Autowired
  public AdminServiceImpl(AdminMapper adminMapper, LogService logService) {
    this.adminMapper = adminMapper;
    this.logService = logService;
  }

  @Override
  public Admin login(String username, String password) {
    String passwordHash = MD5Utils.MD5Encode(password, "");
    return adminMapper.selectByUserNameAndPassword(username, passwordHash);
  }

  @Override
  public ResultVO login(
      LoginUserVO loginUserVO,
      BindingResult result,
      HttpSession session,
      HttpServletRequest request) {
    List<String> errorMessage = new ArrayList<>();

    if (result.hasErrors()) {
      result
          .getFieldErrors()
          .forEach(
              error -> {
                errorMessage.add(error.getDefaultMessage());
              });
      return ResultUtil.error("", errorMessage);
    }

    String verifyCode = session.getAttribute("verifyCode") + "";
    if (!loginUserVO.getVerifyCode().equals(verifyCode)) {
      return ResultUtil.error(400, "验证码错误");
    }

    // encode password
    String passwordHash = MD5Utils.MD5Encode(loginUserVO.getPassword(), "");
    loginUserVO.setPassword(passwordHash);

    Admin adminUser =
        adminMapper.selectByUserNameAndPassword(
            loginUserVO.getUsername(), loginUserVO.getPassword());
    if (adminUser != null) {
      session.setAttribute("loginUser", adminUser.getUsername());
      session.setAttribute("nickName", adminUser.getNickname());
      session.setAttribute("loginUserId", adminUser.getId());
      session.setAttribute("avatar", adminUser.getAvatar());
      session.setMaxInactiveInterval(60 * 60 * 2);
      String ipaddress = IPUtils.getIpAddr(request);
      logService.addRecord(adminUser.getUsername(), ipaddress);
      return ResultUtil.success("登录成功", null);
    } else {
      return ResultUtil.error("登录失败", null);
    }
  }

  @Override
  public int countUser() {
    return adminMapper.totalCount();
  }

  @Override
  public int updatePassword(String RewNewPassword, String username) {
    String ReNewPasswordHash = MD5Utils.MD5Encode(RewNewPassword, "");
    return adminMapper.updateByUserName(ReNewPasswordHash, username);
  }

  @Override
  public AdminVO getCurrentUser(String loginUser) {
    return adminMapper.selectByUserName(loginUser);
  }

  /**
   * 更新当前管理员信息
   *
   * @param adminVO
   * @return
   */
  @Override
  public int updateAdmin(AdminVO adminVO) {
    return adminMapper.updateUserById(adminVO);
  }
}
