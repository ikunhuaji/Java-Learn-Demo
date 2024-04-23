package com.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer1 {
    public static void main(String[] args) {
        try {
            //构建ServerSocket对象
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("启动服务器端");
            while(true){
            Socket socket = serverSocket.accept();
            System.out.println("监听到了客户端");
            //构建流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] cache = new byte[20];
            inputStream.read(cache);
            System.out.println("客户端发过来的数据是：" + new String(cache));

            outputStream.write("received".getBytes());
            outputStream.flush();

            // 关闭socket
            inputStream.close();
            outputStream.close();
            socket.close();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
