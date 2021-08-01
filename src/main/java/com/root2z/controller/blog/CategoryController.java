package com.root2z.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

  @RequestMapping(value = "/{id}")
  public ModelAndView categoryListById(@PathVariable Integer id) {
    return new ModelAndView();
  }
}
