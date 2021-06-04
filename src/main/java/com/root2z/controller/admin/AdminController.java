package com.root2z.controller.admin;

import com.root2z.model.entity.Admin;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.AdminService;
import com.root2z.service.LogService;
import com.root2z.utils.IPUtils;
import com.root2z.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

  private final AdminService userService;

  private final LogService logService;

  @Autowired
  public AdminController(AdminService userService, LogService logService) {
    this.userService = userService;
    this.logService = logService;
  }

  @RequestMapping("/login")
  public String login() {
    return "admin/login";
  }

  /**
   * 进行登录动作 允许登录的时候进行跨域
   *
   * @param username
   * @param password
   * @param verifyCode
   * @param session
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO doLogin(
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam("verifyCode") String verifyCode,
      HttpSession session,
      HttpServletRequest request) {
    // 构造器
    if (StringUtils.isEmpty(verifyCode)) {
      return ResultUtil.error(400, "验证码不能为空");
    }
    if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
      return ResultUtil.error(400, "用户名或密码错误");
    }

    String kaptchaCode = session.getAttribute("verifyCode") + "";
    if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
      return ResultUtil.error(400, "验证码错误");
    }

    Admin adminUser = userService.login(username, password);
    if (adminUser != null) {
      session.setAttribute("loginUser", adminUser.getUsername());
      session.setAttribute("loginUserId", adminUser.getId());
      session.setAttribute("loginNickName", adminUser.getNickname());
      session.setAttribute("avatar", adminUser.getAvatar());
      // session过期时间设置为7200秒 即两小时
      session.setMaxInactiveInterval(60 * 60 * 2);

      String ipaddress = IPUtils.getIpAddr(request);

      // 在查询出记录之后再擦入登录日志
      logService.addRecord(adminUser.getUsername(), ipaddress);

      return ResultUtil.success("登录成功", null);
    } else {
      return ResultUtil.error("登录失败", null);
    }
  }

  @RequestMapping("/index")
  public String index() {
    return "admin/index";
  }
}
