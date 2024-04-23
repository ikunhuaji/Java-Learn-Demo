package com.starrysky.cakelesson.cake.controller;

import com.starrysky.cakelesson.db.Db;
import com.starrysky.cakelesson.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/edit")
public class EditCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Cake cake1=new Cake();
        for(Cake cake: Db.list){
            if(cake.getId()==Integer.parseInt((id))){
                cake1 = cake;
            }
        }

        PrintWriter out = response.getWriter();
        out.print("<html lang=\"en\">\n" +
                    "<head>\n" +
                    "   <meta charset=\"UTF-8\">\n" +
                    "   <title>新增蛋糕</title>\n" +
                    "</head>"+
                    "<body>" +
                    "   <form action='edit' method = 'post'><br>"+
                    "       <input type='hidden' name ='id' value='"+cake1.getId()+"'/><br>"+
                    "       <input type='text' name='name' value='"+cake1.getName()+"'/><br>" +
                    "       <input type ='text' name='price' value='" +cake1.getPrice() + "'/><br>"+
                    "       <textarea name='description' rows='5' cols='100'>" +cake1.getDescription()+ "</textarea><br>"+
                    "       <input type='submit' value='更改' />"+
                    "   </form>"+
                    "</body>" +
                    "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String description = request.getParameter("description");
        for(int i=0;i<Db.list.size();i++)
        {
            if(Db.list.get(i).getId()==id){
                Db.list.get(i).setName(name);
                Db.list.get(i).setPrice(price);
                Db.list.get(i).setDescription(description);
            }
        }

        response.sendRedirect("list");
    }
}
