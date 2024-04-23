package com.starrysky.cakelesson.cake.controller;

import com.starrysky.cakelesson.cake.service.CakeService;
import com.starrysky.cakelesson.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

@WebServlet("/list")
public class ListCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //

        //
        CakeService cakeService = new CakeService();
        List<Cake> list = cakeService.listAll();

        //
        request.setAttribute("cakes",list);
        request.getRequestDispatcher("show").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
