package com.starrysky.learn57;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/send")
public class SendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = request.getParameter("msg");
        Object myself = request.getSession().getAttribute("myself");

        Object objmsgs = this.getServletContext().getAttribute("msgs");
        List<String>msgs;
        if(objmsgs==null){
            msgs = new ArrayList<>();
        }
        else{
            msgs=(List<String>) objmsgs;
        }

        msgs.add(myself+"说："+msg);
        this.getServletContext().setAttribute("msgs",msgs);

        response.sendRedirect("send.html");
    }
}
