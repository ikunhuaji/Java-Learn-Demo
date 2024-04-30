package com.starrysky.cakelesson.cake.controller;

import com.starrysky.cakelesson.cake.service.Cart;
import com.starrysky.cakelesson.cake.service.CartItem;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
@WebServlet("/showcart")
public class ShowCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        Object obj = session.getAttribute("cart");
        out.print("");
        if(obj==null){
            out.print("<h1>暂无购物车数据</h1>");
        }
        else{
            Cart cart = (Cart) obj;

            HashMap<Integer, CartItem>map=cart.getMap();
            map.values().forEach(cartItem -> {
                out.print(cartItem.getCake().getName()+
                        " :"+
                        cartItem.getCount()+
                        "<br>");
            });
        }

        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
