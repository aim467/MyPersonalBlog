package com.root2z.service;

import com.root2z.model.entity.Admin;
import com.root2z.model.vo.AdminVO;
import com.root2z.model.vo.LoginUserVO;
import com.root2z.model.vo.PasswordVO;
import com.root2z.model.vo.ResultVO;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface AdminService {
  Admin login(String username, String password);

  ResultVO login(
      LoginUserVO loginUserVO,
      BindingResult result,
      HttpSession session,
      HttpServletRequest request);

  /**
   * 用户统计
   *
   * @return
   */
  int countUser();

  /**
   * 根据用户名更新密码
   *
   * @return
   */
  ResultVO updatePassword(PasswordVO passwordVO, HttpSession session);

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
