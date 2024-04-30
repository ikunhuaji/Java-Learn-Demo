package com.starrysky.cakelesson.cake.controller;

import com.starrysky.cakelesson.cake.service.CakeService;
import com.starrysky.cakelesson.db.Db;
import com.starrysky.cakelesson.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListCakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //

        //
//        CakeService cakeService = new CakeService();
//        List<Cake> list = cakeService.listAll();

        //

        List<Cake>list = new ArrayList<>();

        for(int i=0;i<10;i++)
        {
            Cake cake =new Cake();
            cake.setId(i+1);
            cake.setName("tmp");
            cake.setDescription(">>>>");
            cake.setPrice(i*100);
            list.add(cake);
        }

        Db.list=list;

        request.setAttribute("cakes",Db.list);
        request.getRequestDispatcher("show").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
