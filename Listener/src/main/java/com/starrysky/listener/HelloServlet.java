package com.starrysky.listener;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //HttpSessionActivationListener 在 session 钝化和激活时监听

        response.setContentType("text/html");

        this.getServletContext().setAttribute("un","张三");

        this.getServletContext().setAttribute("un","李四");
        //ServletContextAttributeListener 监听

        request.getSession().setAttribute("age",20);//不执行binding监听,执行AttributeListener的added
        request.getSession().setAttribute("age",30);//执行AttributeListener的replaced
        request.getSession().removeAttribute("age");//执行AttributeListener的removed
        request.getSession().setAttribute("teacher",new Teacher());//执行监听
        //binding 监听 实现 HttpSessionBindingListener 的类
        //与HttpSessionAttributeListener 区别
        // 1.attribute 监听所有session ，binding 监听实现的类 ;
        // 2，binding 不用在 xml 设置 listener 路径

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        this.getServletContext().removeAttribute("un");
    }

    public void destroy() {
    }
}