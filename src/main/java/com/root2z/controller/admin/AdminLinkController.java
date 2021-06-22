package com.root2z.controller.admin;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Friend;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.FriendService;
import com.root2z.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminLinkController {

  private final Logger logger = LoggerFactory.getLogger(AdminLinkController.class);

  private final FriendService friendService;

  @Autowired
  public AdminLinkController(FriendService friendService) {
    this.friendService = friendService;
  }

  /**
   * 前端从后端获取全部友链
   *
   * @param pageNum 当前页码
   * @param pageSize 当前页面显示个数
   * @return mv
   */
  @RequestMapping(value = "/links")
  public ModelAndView links(
      @RequestParam(value = "pageNum", defaultValue = "1", required = true) Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "4", required = false) Integer pageSize) {

    ModelAndView mv = new ModelAndView();
    mv.setViewName("admin/link/links");
    PageInfo<Friend> pageInfo = friendService.pageQueryFriend(pageNum, pageSize);
    mv.addObject("friendList", pageInfo);
    return mv;
  }

  /**
   * 添加友链
   *
   * @return
   */
  @RequestMapping("/links/add")
  public String addLink() {
    return "admin/link/add";
  }

  @RequestMapping(value = "/links/add", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO addLink(Friend friend) {
    if (friendService.addFriend(friend)) {
      return ResultUtil.success("插入友情链接记录成功", null);
    }
    return ResultUtil.error("插入友情链接失败", null);
  }

  /**
   * 编辑友链，根据友链ID找到友链记录
   *
   * @return String 视图名字
   */
  @RequestMapping("/links/edit/{id}")
  public ModelAndView editLink(@PathVariable("id") Integer id) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("admin/link/edit");
    mv.addObject("friend", friendService.getFriendById(id));
    return mv;
  }

  /**
   * 编辑友链
   *
   * @return String 视图名字
   */
  @RequestMapping(value = "/links/update", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO updateLink(Friend friend) {
    logger.info(friend.toString());
    if (friendService.updateFriend(friend)) {
      return ResultUtil.success("更新成功!", null);
    }
    return ResultUtil.error("更新失败", null);
  }

  /**
   * 删除友链，删除完回到第一页
   *
   * @return 地址
   */
  @RequestMapping("/links/delete/{id}")
  public ModelAndView deleteLink(@PathVariable("id") Integer id) {
    ModelAndView mv = new ModelAndView();
    if (friendService.deleteFriendById(id)) {
      mv.setViewName("redirect:/admin/links");
    }
    return mv;
  }
}
