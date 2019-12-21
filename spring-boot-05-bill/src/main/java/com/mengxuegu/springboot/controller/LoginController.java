package com.mengxuegu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/25 0025 下午 19:22
 * @Description:
 */

@Controller
public class LoginController {
    @PostMapping("/login")
    public String login(HttpSession session, String username, String password, Map<String, Object> map) {
        //判断用户名不为空,且密码为123,则登录成功
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }
        map.put("msg", "用户名或密码错误");
        return "main/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        //1.清空session中的用户信息
        session.removeAttribute("loginUser");
        //2.再将session进行注销
        session.invalidate();
        //3.重定向到登录页面
        return "redirect:/index.html";
    }
}
