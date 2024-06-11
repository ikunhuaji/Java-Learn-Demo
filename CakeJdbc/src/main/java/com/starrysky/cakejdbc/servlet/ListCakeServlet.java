package com.starrysky.cakejdbc.servlet;

import com.starrysky.cakejdbc.dao.CakeDao;
import com.starrysky.cakejdbc.item.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class ListCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        List<Cake> cakes = new CakeDao().findByNormalState();

        if(cakes.size()==0){
            out.print("<h1>暂无蛋糕数据</h1>");
        }
        else{
            out.print("<html><body><table border='1'>");
            out.print("<tr><td>编号</td><td>名称</td><td>价格</td><td>操作</td></tr>");
            for(Cake cake:cakes)
            {
                out.print("<tr><td>"+cake.getId()+"</td><td>"+
                        cake.getName()+"</td><td>"+
                        cake.getPrice()+"</td><td>"+
                        "<a href='update?id="+cake.getId()+"'>下架</a>"+"</td></tr>");
            }

            out.print("</table>" +
                    "</body></html>");
            out.flush();
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
