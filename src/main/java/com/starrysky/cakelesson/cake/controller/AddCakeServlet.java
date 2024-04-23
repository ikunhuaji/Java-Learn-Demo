package com.starrysky.cakelesson.cake.controller;

import com.starrysky.cakelesson.cake.service.CakeService;
import com.starrysky.cakelesson.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/add")
public class AddCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");

        //业务
        Cake cake = new Cake(name,Integer.parseInt(price),description);

        CakeService cakeService = new CakeService();
        cakeService.addCake(cake);

        //响应
        response.sendRedirect("addCake.html");
    }
}
