package com.it.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取前端参数
        String method = request.getParameter("method");
        if (method.equals("add")) {
            request.getSession().setAttribute("msg", "执行了add方法");
        }
        if (method.equals("delete")) {
            request.getSession().setAttribute("msg", "执行了delete方法");
        }
        //2.调用业务层

        //3.视图转发或者重定向
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
    }
}
