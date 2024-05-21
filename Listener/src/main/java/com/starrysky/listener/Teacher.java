package com.starrysky.listener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class Teacher implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("binding: " + event.getName());
        System.out.println("binding: " + event.getValue());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }
}
