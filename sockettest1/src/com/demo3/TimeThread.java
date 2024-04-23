package com.demo3;

public class TimeThread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(180000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CheckServer.isContinue = false;
    }
}
