package com.root2z.controller.admin;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Message;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.MessageService;
import com.root2z.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminMessageController {

  private final MessageService messageService;

  private List<Message> messageList = new ArrayList<>();

  @Autowired
  public AdminMessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  /**
   * 返回到留言列表视图
   *
   * @return
   */
  @RequestMapping(value = "/message")
  public ModelAndView messagesPage() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("admin/message/list");
    return mv;
  }

  /**
   * 分页返回留言列表
   *
   * @param pageNum 当前页码
   * @param pageSize 每页大小
   * @return
   */
  @RequestMapping(value = "/messages")
  @ResponseBody
  public Map<String, Object> messageList(
      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "3", required = false) Integer pageSize) {
    PageInfo<Message> messagePageInfo = messageService.pageQueryMessages(pageNum, pageSize);
    Map<String, Object> result = new HashMap<>();
    result.put("total", messagePageInfo.getTotal());
    result.put("rows", messagePageInfo.getList());
    return result;
  }

  @RequestMapping(value = "/message/reply", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO replyMessage(Message message) {
    if (messageService.insertMessage(message)) {
      return ResultUtil.success("回复成功!", null);
    }
    return ResultUtil.error("回复失败!", null);
  }

  /**
   * 删除此回复，会删除连带的回复
   *
   * @param messageId
   * @return
   */
  @RequestMapping(value = "/message/delete", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO deleteMessage(@RequestParam("id") Integer messageId) {
    if (messageService.deleteMessage(messageId)) {
      return ResultUtil.success("删除成功!", null);
    }
    return ResultUtil.error("删除失败", null);
  }
}
