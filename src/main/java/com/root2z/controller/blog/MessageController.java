package com.root2z.controller.blog;

import com.root2z.model.entity.Message;
import com.root2z.model.vo.ResultVO;
import com.root2z.service.MessageService;
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

@Controller
@RequestMapping(value = "/message")
public class MessageController {

  @Autowired private MessageService messageService;

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  @ResponseBody
  public ResultVO saveMessage(@Validated Message message, BindingResult result) {
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
    return messageService.addMessage(message);
  }
}
