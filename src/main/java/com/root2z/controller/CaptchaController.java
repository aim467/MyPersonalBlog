package com.root2z.controller;

import com.wf.captcha.GifCaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

/**
 * @author root2z
 */
@Controller
public class CaptchaController {

    /**
     * 返回验证码视图
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException 异常
     */
    @RequestMapping(value = "/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 设置请求头为输出图片类型
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        // 三个参数分别为宽、高、位数
        GifCaptcha gitCaptcha = new GifCaptcha(130, 40, 5);
        // 设置字体
        gitCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));

        // 验证码存入session
        request.getSession().setAttribute("captcha", gitCaptcha.text().toLowerCase());

        // 输出图片流
        gitCaptcha.out(response.getOutputStream());
    }
}
