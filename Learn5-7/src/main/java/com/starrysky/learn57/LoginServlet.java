package com.starrysky.learn57;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        Object obj= this.getServletContext().getAttribute("names");
        if(obj==null)
        {
            request.getSession().setAttribute("myself",username);
            LinkedHashSet<String>names = new LinkedHashSet<>();
            names.add(username);
            this.getServletContext().setAttribute("names",names);
            response.sendRedirect("main.html");
        }
        else {
            LinkedHashSet<String>names = (LinkedHashSet<String>) obj;
            if(names.contains(username)) {
                request.setAttribute("errorinfo","账号已存在");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            else{
                request.getSession().setAttribute("myself",username);
                names.add(username);
                this.getServletContext().setAttribute("names",names);
                response.sendRedirect("main.html");
            }
        }
    }
}
