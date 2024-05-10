package com.starrysky.learn57;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/msg")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.print("<html><head><meta http-equiv='refresh' content='1' /></head><body>");
//        out.print("<html><head></head><body>");

        Object obj = this.getServletContext().getAttribute("msgs");

        if(obj!=null){
            List<String>msgs = (List<String>) obj;

            msgs.forEach(msg->{
                out.print(msg+"<br>");
            });
        }

        out.print("</body></html>");

        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
