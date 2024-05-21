package com.starrysky.filter.order;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebFilter("/*")
public class Filter2 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init Filter2");
    }

    public void destroy() {
        System.out.println("Filter2 destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter2 begin");
        chain.doFilter(request, response);
        System.out.println("Filter2 end");
    }
}
