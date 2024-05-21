package com.starrysky.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//在 xml 中设置 Filter 的位置与过滤

//@WebFilter("/index.jsp")
public class CharFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html;charset=UTF-8");

        System.out.println("Filter begin");
        filterChain.doFilter(servletRequest,servletResponse);

//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.sendRedirect("");

        System.out.println("Filter end");
    }

    @Override
    public void destroy() {

    }
}
