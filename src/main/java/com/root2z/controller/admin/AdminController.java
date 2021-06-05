package com.root2z.controller.admin;

import com.root2z.controller.BaseController;
import com.root2z.model.entity.Admin;
import com.root2z.model.vo.ResultVO;
import com.root2z.utils.IPUtils;
import com.root2z.utils.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

  @RequestMapping("/login")
  public String login() {
    return "admin/login";
  }

  /**
   * 正真的登录动作
   *
   * @param username
   * @param password
   * @param verifyCode
   * @return
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO doLogin(
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      @RequestParam("verifyCode") String verifyCode) {
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

    Admin adminUser = adminService.login(username, password);
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
  public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("userCount", adminService.countUser());
    modelAndView.addObject("articleCount", articleService.countArticle());
    modelAndView.addObject("tagCount", tagService.countTag());
    modelAndView.addObject("categoryCount", categoryService.countCategory());
    modelAndView.addObject("commentCount", commentService.countComment());
    modelAndView.addObject("friendCount", friendService.countFriend());
    modelAndView.addObject("logCount", logService.countLog());
    modelAndView.addObject("messageCount", messageService.countMessage());
    modelAndView.setViewName("admin/index");
    return modelAndView;
  }

  @RequestMapping("/logout")
  public String logout() {
    session.invalidate();
    return "redirect:/admin/login";
  }

  @RequestMapping("/password")
  public String password() {
    return "admin/editPass";
  }

  @RequestMapping(value = "/password", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO updatePassword(
      @RequestParam("newPassword") String newPassword,
      @RequestParam("ReNewPassword") String reNewPassword,
      @RequestParam("oldPassword") String oldPassword) {
    if (newPassword.equals("") || reNewPassword.equals("") || oldPassword.equals("")) {
      return ResultUtil.error(400, "没有填写数据");
    } else if (newPassword != reNewPassword) {
      return ResultUtil.error(400, "密码不一致");
    }

    Integer loginUserId = (Integer) session.getAttribute("loginUserId");

    int result = adminService.updatePassword(reNewPassword, loginUserId);
    if (result == 0) {
      return ResultUtil.error(400, "更新失败");
    }
    return ResultUtil.success("更新成功", "");
  }
}
