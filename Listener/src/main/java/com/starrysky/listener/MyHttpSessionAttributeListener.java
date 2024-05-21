package com.starrysky.listener;

import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("session add: "+event.getName());
        System.out.println("add value: "+event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("session remove: " + event.getName());
        System.out.println("session remove: " + event.getValue());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("session replace: " + event.getName());
        System.out.println("session replace: " + event.getValue());

        System.out.println("session new: "+event.getSession().getAttribute(event.getName()));
    }
}
