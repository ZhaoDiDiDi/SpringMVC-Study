package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {

    //跳转到登录页面
    @RequestMapping("/jumplogin")
    public String jumpLogin() {
        return "login";
    }

    //跳转到成功页面
    @RequestMapping("/jumpsuccess")
    public String jumpSuccess() {
        return "success";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model) {
        System.out.println("接受前端===" + username);
        //把用户的信息存在session中
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username", username);
        return "success";
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //session过期
        session.invalidate();
        return "login";
    }
}
