package com.starrysky.cakelist;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    public Constant constant = new Constant();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cakeName = request.getParameter("cakename");
        String cakeSize = request.getParameter("cakesize");
        String cakeColor = request.getParameter("cakecolor");

        Cake cake= new Cake(cakeName,cakeSize,cakeColor);
        constant.add(cake);
        cake.show();

        request.setAttribute("courseInfo",constant);

        request.getRequestDispatcher("showcake").forward(request,response);
    }
}
