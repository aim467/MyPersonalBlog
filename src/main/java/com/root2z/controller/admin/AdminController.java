package com.root2z.controller.admin;

import com.root2z.controller.BaseController;
import com.root2z.model.vo.AdminVO;
import com.root2z.model.vo.LoginUserVO;
import com.root2z.model.vo.PasswordVO;
import com.root2z.model.vo.ResultVO;
import com.root2z.utils.FileUtils;
import com.root2z.utils.ResultUtil;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

  @RequestMapping("/login")
  public String login() {
    return "admin/login";
  }

  /** 执行登录操作 */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO doLogin(@Validated LoginUserVO loginUserVO, BindingResult result) {
    return adminService.login(loginUserVO, result, session, request);
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
  public ResultVO updatePassword(@Validated PasswordVO passwordVO, BindingResult result) {
    if (result.hasErrors()) {
      return ResultUtil.error("数据有误!", null);
    }
    return adminService.updatePassword(passwordVO, session);
  }

  @RequestMapping("/profile")
  public ModelAndView profile() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("admin/profile");
    String loginUser = (String) session.getAttribute("loginUser");
    mv.addObject("currentUser", adminService.getCurrentUser(loginUser));
    return mv;
  }

  /**
   * ` 更新管理员信息 头像上传和信息分两个视图 头像使用 ajax上传时 返回结果赋值到 value 里面 同时，如果进入 profile页面的时候 填充好表单信息
   *
   * @return
   */
  @RequestMapping(value = "/profile", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO updateProfile(AdminVO adminVO) {
    int result = adminService.updateAdmin(adminVO);
    if (result == 0) {
      return ResultUtil.error(400, "更新失败");
    }
    return ResultUtil.success("更新成功", null);
  }

  /**
   * 上传完图片再回显图片地址
   *
   * @return
   */
  @RequestMapping(value = "/picture", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO uploadPicture(@RequestParam("fileName") MultipartFile file) {

    // 获取单文件名
    String fileName = file.getOriginalFilename();

    // 判断文件类型
    String fileType = file.getContentType();

    // 判断文件类型
    if (fileType.equals("image/jpg")
        || fileType.equals("image/png")
        || fileType.equals("image/jpeg")) {

      String randomFileName = FileUtils.upload(file, fileName);

      if (randomFileName.equals("")) {
        return ResultUtil.error("上传失败", null);
      } else {
        String relativePath = "/Image/" + randomFileName;
        return ResultUtil.success("图片上传成功!", relativePath);
      }
    }
    return ResultUtil.error("文件类型不支持", null);
  }
}
