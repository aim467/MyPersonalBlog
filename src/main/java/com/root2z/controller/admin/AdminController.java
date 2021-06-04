package com.root2z.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @RequestMapping("/login")
    public String login() {
        return "admin/login";
    }
}
