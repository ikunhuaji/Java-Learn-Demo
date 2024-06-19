package com.starrysky.androidhomeworkservlet.servlet;

import com.starrysky.androidhomeworkservlet.Dao.TotalBuyDao;
import com.starrysky.androidhomeworkservlet.entity.ResultUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/addTotalBuy")
public class AddTotalBuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter os = response.getWriter();

        String userName = request.getParameter("userName");
        String buyTime = request.getParameter("buyTime");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));

        TotalBuyDao.add(userName,buyTime,totalPrice);

        os.write(ResultUtils.success("成功","addTotalBuy"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
