package com.starrysky.servlettest;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class CakeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = this.getServletContext().getAttribute("count");

        if(obj==null){
            this.getServletContext().setAttribute("count",1);
        }
        else{
            int cout = Integer.parseInt(obj.toString());
            cout++;
            this.getServletContext().setAttribute("count",cout);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
