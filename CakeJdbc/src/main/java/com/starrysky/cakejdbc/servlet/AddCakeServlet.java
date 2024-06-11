package com.starrysky.cakejdbc.servlet;

import com.starrysky.cakejdbc.dao.CakeDao;
import com.starrysky.cakejdbc.item.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/add")
public class AddCakeServlet extends HttpServlet {

    public static int id=1;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        PrintWriter out = response.getWriter();

        int cnt = CakeDao.getSize();

        Cake cake = new Cake(cnt+1,name,price,1);

        CakeDao cakeDao = new CakeDao();

        cakeDao.saveCake(cake);

        response.sendRedirect("list");
    }
}
