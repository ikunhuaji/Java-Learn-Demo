package com.starrysky.cakelist;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<html><body>");
        response.getWriter().write("<title>http://localhost:8080/CakeList_war_exploded/showcake/</title>");
        Constant constant=(Constant) request.getAttribute("courseInfo");

        response.getWriter().write("<h1>");
        response.getWriter().write("蛋糕 名称 尺寸 颜色");
        response.getWriter().write("</h1>");

        for(int i=0;i<constant.list.size();i++)
        {
            response.getWriter().write("<h1>");
            response.getWriter().write("蛋糕"+ (i+1) + ": ");
            response.getWriter().write(constant.list.get(i).showcake());
            response.getWriter().write("</h1>");
        }

        response.getWriter().write("<a href=" +"\" http://localhost:8080/CakeList_war_exploded/ \"> 返回 </a>");

        response.getWriter().write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<html><body>");

        response.getWriter().write("<a href=" +"\" showcake \"> 展示保存的蛋糕数据 </a><br>");
        response.getWriter().write("<a href=" +"\" http://localhost:8080/CakeList_war_exploded/ \"> 返回 </a>");

        response.getWriter().write("</body></html>");
    }
}
