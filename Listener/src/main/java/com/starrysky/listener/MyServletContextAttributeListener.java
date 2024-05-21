package com.starrysky.listener;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;


public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {//当ServletAttribute添加元素监听
        System.out.println(event.getName());
        System.out.println(event.getValue());

//        event.getServletContext().removeAttribute(event.getName());//存就删
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {//当ServletAttribute删除元素监听
        System.out.println("remove: " + event.getName());
        System.out.println("remove: " + event.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {//当ServletAttribute修改元素监听
        System.out.println("replace: " + event.getName());
        System.out.println("replace: " + event.getValue());

        System.out.println("new: "+event.getServletContext().getAttribute(event.getName()));
    }
}
