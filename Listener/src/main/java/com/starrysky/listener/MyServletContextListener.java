package com.starrysky.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {//初始化时执行
        System.out.println("context init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {//销毁时执行
        System.out.println("context destroy");
    }
}
