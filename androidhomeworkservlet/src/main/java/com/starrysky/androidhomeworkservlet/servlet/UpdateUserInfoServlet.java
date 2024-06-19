package com.starrysky.androidhomeworkservlet.servlet;

import com.starrysky.androidhomeworkservlet.Dao.UserInfoDao;
import com.starrysky.androidhomeworkservlet.entity.ResultUtils;
import com.starrysky.androidhomeworkservlet.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/updateUserInfo")
public class UpdateUserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter os = response.getWriter();

//        System.out.println("进入");

        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String nickName = request.getParameter("nickName");
        int id = Integer.parseInt(request.getParameter("id"));
        String avatar = request.getParameter("avatar");

        User user = new User(userName,pwd,email,nickName,id,avatar);

        UserInfoDao.updateUserInfo(id,user);

        os.write(ResultUtils.success("更改成功",user));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
