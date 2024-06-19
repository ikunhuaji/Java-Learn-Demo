package com.starrysky.androidhomeworkservlet.servlet;

import com.starrysky.androidhomeworkservlet.Dao.ProductDao;
import com.starrysky.androidhomeworkservlet.entity.ResultUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getNowCnt")
public class GetNowCntServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter os = response.getWriter();

//        System.out.println("进入");
        String name = request.getParameter("name");

        int nowCnt = ProductDao.getCnt(name);

        os.write(ResultUtils.success("成功",nowCnt));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
