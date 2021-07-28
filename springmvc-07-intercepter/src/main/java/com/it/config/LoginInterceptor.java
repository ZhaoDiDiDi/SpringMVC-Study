package com.it.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果是登录页面就放行
        System.out.println("url:" + request.getRequestURI());
        if (request.getRequestURI().contains("login")) {
            return true;
        }
//        if (request.getRequestURI().contains("logout")) {
//            return true;
//        }
        HttpSession session = request.getSession();
        //已登录可放行
        if (session.getAttribute("userLoginInfo") != null) {
            return true;
        }
        // 用户没有登陆跳转到登陆页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }
}
