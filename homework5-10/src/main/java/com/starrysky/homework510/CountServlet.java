package com.starrysky.homework510;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/showCount")
public class CountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.write("<html><body>");

        out.write("个人访问:"+"<br>");

        Object myObj = request.getSession().getAttribute("mycnt");

        if(myObj!=null){
            List<Integer>myCnt = (List<Integer>) myObj;
            for(int i=1;i<=10;i++)
            {
                out.write("产品"+ i +":"+myCnt.get(i-1)+"<br>");
            }
        }
        else out.print("空<br>");

        out.write("总访问:"+"<br>");

        Object totalObj = this.getServletContext().getAttribute("totalcnt");

        if(totalObj!=null){
            List<Integer>totalCnt = (List<Integer>) totalObj;
            for(int i=1;i<=10;i++)
            {
                out.write("产品"+ i +":"+totalCnt.get(i-1)+"<br>");
            }
        }
        else out.print("空<br>");

        out.write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
