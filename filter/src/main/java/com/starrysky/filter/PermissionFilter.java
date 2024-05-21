package com.starrysky.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebFilter("/cake/*")//过滤cake页面
public class PermissionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;
        Object un = req.getSession().getAttribute("un");
        if(un!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else{
            rep.sendRedirect("/filter_war_exploded/index.jsp");// /默认在8080根目录

//            req.getRequestDispatcher("/index.jsp").forward(req,rep);// /默认在exploded根目录
        }
    }
}
