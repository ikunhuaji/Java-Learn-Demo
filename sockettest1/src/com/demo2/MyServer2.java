package com.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer2 {
    public static void main(String[] args) {
        try {
            //构建ServerSocket对象
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("启动服务器端");
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("监听到了客户端");
                new Thread(new ServerThread2(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
