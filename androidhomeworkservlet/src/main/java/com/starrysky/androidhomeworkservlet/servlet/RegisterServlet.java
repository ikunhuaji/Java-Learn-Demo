package com.starrysky.androidhomeworkservlet.servlet;

import com.starrysky.androidhomeworkservlet.Dao.UserInfoDao;
import com.starrysky.androidhomeworkservlet.entity.ResultUtils;
import com.starrysky.androidhomeworkservlet.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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

        if(userName == null||"".equals(userName)){
            os.write(ResultUtils.error("用户名不能为空"));
        }else if(pwd == null||"".equals(pwd)){
            os.write(ResultUtils.error("密码不能为空"));
        }else if(email == null||"".equals(email)){
            os.write(ResultUtils.error("邮箱不能为空"));
        }else if(nickName == null||"".equals(nickName)){
            os.write(ResultUtils.error("昵称不能为空"));
        } else{
            int id = UserInfoDao.findByName(userName);

            if(id!=0){
                os.write(ResultUtils.error("用户已存在"));
            }else{
                id=UserInfoDao.getSize()+1;
                User user = new User(userName,pwd,email,nickName,id,null);

                UserInfoDao.saveUser(user);
                os.write(ResultUtils.success("注册成功",user));
            }
        }
    }
}
