package com.starrysky.cakelesson.cake.controller;

import com.starrysky.cakelesson.cake.service.CakeService;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        String id = request.getParameter("id");
        //
        CakeService cakeService = new CakeService();
        cakeService.removeCake(Integer.parseInt(id));

        //
        response.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
