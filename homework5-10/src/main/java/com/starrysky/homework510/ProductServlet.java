package com.starrysky.homework510;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        List<Integer> totalCnt;
        List<Integer> myCnt;

        Object totalObj = this.getServletContext().getAttribute("totalcnt");
        Object myObj = request.getSession().getAttribute("mycnt");

        if(totalObj==null){
            totalCnt = new ArrayList<>();
            for(int i=0;i<10;i++)totalCnt.add(0);
        }
        else{
            totalCnt=(List<Integer>) totalObj;
        }

        if(myObj==null){
            myCnt = new ArrayList<>();
            for(int i=0;i<10;i++)myCnt.add(0);
        }
        else{
            myCnt=(List<Integer>) myObj;
        }

        int idx=Integer.parseInt(id);
        totalCnt.set(idx-1,totalCnt.get(idx-1)+1);
        myCnt.set(idx-1,myCnt.get(idx-1)+1);

        this.getServletContext().setAttribute("totalcnt",totalCnt);
        request.getSession().setAttribute("mycnt",myCnt);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.write("<html><body>访问成功</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
