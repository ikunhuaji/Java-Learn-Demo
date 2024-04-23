package com.starrysky.servlettest;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        ServletConfig servletConfig = this.getServletConfig();
        String url = servletConfig.getInitParameter("url");//获取 HelloServle t默认参数
        String url1 = getInitParameter("url");

        ServletContext ctx = this.getServletContext();
        String globalString = ctx.getInitParameter("globalString");//所有 Servlet 都可获取

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}