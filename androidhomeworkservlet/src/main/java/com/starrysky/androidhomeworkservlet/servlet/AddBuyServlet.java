package com.starrysky.androidhomeworkservlet.servlet;

import com.starrysky.androidhomeworkservlet.Dao.BuyDao;
import com.starrysky.androidhomeworkservlet.Dao.TotalBuyDao;
import com.starrysky.androidhomeworkservlet.entity.ResultUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addBuy")
public class AddBuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter os = response.getWriter();

//        System.out.println("进入");

        String userName = request.getParameter("userName");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int cnt = Integer.parseInt(request.getParameter("cnt"));
        String img = request.getParameter("img");
        String buyTime = request.getParameter("buyTime");

        BuyDao.add(userName,name,price,cnt,img,buyTime);

        os.write(ResultUtils.success("成功","addBuy"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
