package com.starrysky.androidhomeworkservlet.servlet;

import com.starrysky.androidhomeworkservlet.Dao.UserInfoDao;
import com.starrysky.androidhomeworkservlet.entity.ResultUtils;
import com.starrysky.androidhomeworkservlet.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=utf-8");
        PrintWriter os = response.getWriter();

//        System.out.println("进入");

        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");

        if(userName == null||"".equals(userName)){
            os.write(ResultUtils.error("用户名不能为空"));
        }else if(pwd == null||"".equals(pwd)) {
            os.write(ResultUtils.error("密码不能为空"));
        }else{
            int id = UserInfoDao.findByName(userName);

            if(id==0){
                os.write(ResultUtils.error("用户不存在"));
            }else{
                User user = UserInfoDao.findInfo(userName);

                if(user.getPwd().equals(pwd)){
                    os.write(ResultUtils.success("登录成功",user));
                }
                else{
                    os.write(ResultUtils.error("密码错误"));
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
