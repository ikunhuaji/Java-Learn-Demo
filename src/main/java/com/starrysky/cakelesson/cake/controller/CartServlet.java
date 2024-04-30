package com.starrysky.cakelesson.cake.controller;

import com.starrysky.cakelesson.cake.service.Cart;
import com.starrysky.cakelesson.db.Db;
import com.starrysky.cakelesson.entity.Cake;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/buy")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Cake cake = null;
        for (Cake it: Db.list){
            if (it.getId()==Integer.parseInt(id)){
                cake=it;
            }
        }

        HttpSession session = request.getSession();

        Cart cart=null;
        Object obj = session.getAttribute("cart");
        if(obj!=null){
            cart=(Cart) obj;
        }
        else{
            cart=new Cart();
        }

        //Cart cart = new Cart();
        cart.addCake(cake);
        session.setAttribute("cart",cart);
        response.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
