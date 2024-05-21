package com.starrysky.filter.order;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
@WebFilter("/*")

public class Filter1 implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init Filter1");
    }

    public void destroy() {
        System.out.println("Filter1 destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter1 begin");
        chain.doFilter(request, response);
        System.out.println("Filter1 end");
    }
}
