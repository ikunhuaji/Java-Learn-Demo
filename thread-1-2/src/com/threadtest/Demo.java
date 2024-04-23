package com.threadtest;

/**
 * 1. 程序、进程、线程
 * 2. 线程生命周期的五个状态
 * 3. 新建线程，2个方式，继承Thread类，实现Runnable
 *  class My extends Thread
 *  My my = new My();
 *  my.start();
 *  ===============================
 *  class My1 implements Runnable
 *  My1 my1 = new My1();
 *  new Thread(my1).start();
 */
public class Demo {
    public static void main(String[] args) {

        CountThread countThread = new CountThread();
        Thread thread = new Thread(countThread);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        new Thread(countThread).start();

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
