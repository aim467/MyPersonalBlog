package com.root2z.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/tag")
public class TagController {

  /**
   * 标签列表
   *
   * @return
   */
  @RequestMapping(value = "/{id}")
  public ModelAndView tagList(@PathVariable Integer id) {
    return new ModelAndView();
  }
}
