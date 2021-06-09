package com.root2z.controller.admin;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Friend;
import com.root2z.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminLinkController {

  @Autowired private FriendService friendService;

  @RequestMapping("/links")
  @ResponseBody
  public ModelAndView links(
      @RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {
    ModelAndView mv = new ModelAndView();
    PageInfo<Friend> friends = friendService.pageQueryFriend(pageNum, pageSize);
    mv.addObject("friendList", friends);
    mv.setViewName("admin/links");
    return mv;
  }
}
