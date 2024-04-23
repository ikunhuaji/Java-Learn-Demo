package com.demo4;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Client {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        //设置标题
        jframe.setTitle("监控屏幕工具");
        JLabel label = new JLabel();
        jframe.add(label);
        jframe.setSize(800,600);
        //设置可见
        jframe.setVisible(true);
        //设置置顶
        jframe.setAlwaysOnTop(true);
        //控制台退出模式
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true){
            BufferedImage img= ScreenShot.getScreen();
            img=ScreenShot.resize(img, jframe.getWidth(), jframe.getHeight());
            label.setIcon(new ImageIcon(img));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
