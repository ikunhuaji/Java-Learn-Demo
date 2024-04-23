package com.starrysky.webee1.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class RegistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String gender = request.getParameter("gender");
        String home = request.getParameter("home");
        String[] hobbies = request.getParameterValues("hobby");
        //完成
        System.out.println("姓名： "+username);
        System.out.println("密码： "+pwd);
        System.out.println("性别： "+gender);
        System.out.println("籍贯： "+home);
        System.out.print("爱好：");
        for(String hobby:hobbies)
        {
            System.out.print(hobby+" ");
        }
        System.out.println();
        //响应
        System.out.println("注册成功");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<html><body><h3>OK</h3></body></html>");
    }
}
