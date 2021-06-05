package com.root2z.controller;

import com.root2z.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 所有控制器的基类，子类可以隐式的从父类获取需要的对象 */
public class BaseController {

  @Autowired public AdminService adminService;
  @Autowired public ArticleService articleService;
  @Autowired public CategoryService categoryService;
  @Autowired public TagService tagService;
  @Autowired public FriendService friendService;
  @Autowired public CommentService commentService;
  @Autowired public MessageService messageService;
  @Autowired public LogService logService;

  protected HttpServletRequest request;
  protected HttpServletResponse response;
  protected HttpSession session;

  /** 在每个子类方法调用之前先调用，设置request,response,session这三个对象 */
  @ModelAttribute
  public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
    this.request = request;
    this.response = response;
    this.session = request.getSession(true);
  }
}
