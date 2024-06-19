package com.starrysky.androidhomeworkservlet.servlet;

import com.starrysky.androidhomeworkservlet.Dao.CartDao;
import com.starrysky.androidhomeworkservlet.entity.ResultUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addCart")
//详情页添加
public class AddCartServlet extends HttpServlet {
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

        CartDao.addCart(userName,name,price,cnt,img);

        os.write(ResultUtils.success("成功","成功"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
