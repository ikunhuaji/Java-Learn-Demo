package com.demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient1 {
    public static void main(String[] args) {
        try {
            //构建Socket
            Socket socket = new Socket("127.0.0.1", 8888);
            //构建流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write("helloworld".getBytes());
            outputStream.flush();

            byte[] cache = new byte[20];
            inputStream.read(cache);
            System.out.println("服务端发过来的数据是：" + new String(cache));

            // 关闭socket
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
