package com.root2z.controller.blog;

import com.root2z.model.entity.Comment;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.CommentService;
import com.root2z.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/** @author root2z */
@Controller
@RequestMapping(value = "/comment")
public class CommentController {

  @Autowired private CommentService commentService;

  /**
   * 保存评论
   *
   * @return
   */
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO saveComment(@Validated Comment comment, BindingResult result) {
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
    return commentService.saveComment(comment);
  }
}
