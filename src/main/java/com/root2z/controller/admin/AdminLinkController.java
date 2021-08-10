package com.root2z.controller.admin;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Friend;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.FriendService;
import com.root2z.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminLinkController {

  private final FriendService friendService;

  @Autowired
  public AdminLinkController(FriendService friendService) {
    this.friendService = friendService;
  }

  /**
   * 到达友链管理页面
   *
   * @return
   */
  @RequestMapping(value = "/link")
  private String linksPage() {
    return "admin/link/links";
  }

  /**
   * 前端从后端获取全部友链
   *
   * @param pageNum 当前页码
   * @param pageSize 当前页面显示个数
   * @return mv
   */
  @RequestMapping(value = "/links")
  @ResponseBody
  public Map<String, Object> links(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "4", required = false) Integer pageSize) {
    Map<String, Object> result = new HashMap<>();
    PageInfo<Friend> pageInfo = friendService.pageQueryFriend(pageNum, pageSize);
    result.put("rows", pageInfo.getList());
    result.put("total", pageInfo.getTotal());
    return result;
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
   * 编辑友链
   *
   * @return String 视图名字
   */
  @RequestMapping(value = "/links/update", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO updateLink(Friend friend) {
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
  @RequestMapping(value = "/links/delete/{id}", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO deleteLink(@PathVariable("id") Integer id) {
    if (friendService.deleteFriendById(id)) {
      return ResultUtil.success("删除成功!", null);
    }
    return ResultUtil.error("删除失败!", null);
  }
}
