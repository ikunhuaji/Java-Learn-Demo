package com.starrysky.servlettest;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object obj = this.getServletContext().getAttribute("count");
        if(obj==null)
        {
            response.getWriter().write("<html><body><h1>0</h1></body></html>");
        }
        else{
            response.getWriter().write("<html><body><h1>");
            response.getWriter().write(""+Integer.parseInt(obj.toString()));
            response.getWriter().write("</h1></body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
