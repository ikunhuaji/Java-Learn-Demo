package com.starrysky.sessionlession;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/login")

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        HttpSession session = request.getSession();//不加参数相当于 true
        //session失效：
        //session 在用户超过30分钟的非法状态时会自动销毁
        //可在web.xml 的 <session-config> 的 <session-timeout> 改时间

        //也可用
        //session.setMaxInactiveInterval(600);//默认单位为秒

        //cookie失效：
        //关闭浏览器时销毁cookie

        session.setAttribute("un",username);//类似 request 的 setAttribute

        response.sendRedirect("center");
    }
}
