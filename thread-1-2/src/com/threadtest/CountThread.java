package com.threadtest;

public class CountThread implements Runnable{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("countThread" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
