package com.root2z.controller.admin;

import com.github.pagehelper.PageInfo;
import com.root2z.model.entity.Comment;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.CommentService;
import com.root2z.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/admin")
public class AdminCommentController {

  private final Logger logger = LoggerFactory.getLogger(AdminCommentController.class);

  private final CommentService commentService;

  @Autowired
  public AdminCommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  /**
   * 返回评论列表页面
   *
   * @return
   */
  @RequestMapping(value = "/comment")
  public String commentPage() {
    return "admin/comment/list";
  }

  @RequestMapping(value = "/comments", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> comments(
      @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
    Map<String, Object> result = new HashMap<>();
    PageInfo<Comment> commentPageInfo = commentService.pageQueryComment(pageNum, pageSize);
    result.put("total", commentPageInfo.getTotal());
    result.put("rows", commentPageInfo.getList());
    return result;
  }

  @RequestMapping(value = "/comment/reply", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO replyComment(Comment comment, HttpSession session) {
    comment.setCommentator((String) session.getAttribute("nickName"));
    if (commentService.replyComment(comment)) {
      return ResultUtil.success("回复评论成功!", null);
    }
    return ResultUtil.error("回复评论错误！", null);
  }

  /**
   * 删除评论，逻辑删除
   *
   * @return
   */
  @RequestMapping(value = "/comment/delete", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO deleteComment(@RequestParam("commentId") Integer commentId) {
    if (commentService.deleteComment(commentId)) {
      return ResultUtil.success("删除成功!", null);
    }
    return ResultUtil.error("删除评论失败!", null);
  }
}
