package com.starrysky.learn57;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;

@WebServlet("/names")
public class NamesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        Object obj = this.getServletContext().getAttribute("names");
        String myself = (String) request.getSession().getAttribute("myself");

        if(obj!=null){
            out.print("<html><head><meta http-equiv='refresh' content='1' /></head><body>");

            LinkedHashSet<String> names = (LinkedHashSet<String>) obj;

            names.forEach(name->{
//                if(name.equals(myself)){
//                    out.print(name+"<br>");
//                }
//                else{
//                    out.print(name+"<br>");
//                }

                if(!name.equals(myself))out.print(name+"<br>");
                else out.print("<p><font color='red'>"+name+"</font></p>");
            });

            out.print("</body></html>");
        }
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
