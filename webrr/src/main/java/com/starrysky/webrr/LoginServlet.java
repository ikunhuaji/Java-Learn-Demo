package com.starrysky.webrr;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");
        System.out.println(name);


//        PrintWriter out = response.getWriter();
//        out.print("Hello "+name);
//        out.flush();
//        out.close();

        //requestion 使用 Attribute 可使response带有数据 ， 转发请求可调取
        request.setAttribute("courseInfo","java");

        //重定向 无法获取原参数数据
//        response.sendRedirect("show");

        //转发请求 可获取原参数数据
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show");
//        requestDispatcher.forward(request,response);
        //或
        request.getRequestDispatcher("show").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求
        request.getParameter("");

    }
}
