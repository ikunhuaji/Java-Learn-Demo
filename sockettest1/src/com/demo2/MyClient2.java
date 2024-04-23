package com.demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient2 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            //构建Socket
            Socket socket = new Socket("127.0.0.1", 8888);
            //构建流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            while(true) {
                String line = input.nextLine();
                outputStream.write(line.getBytes());
                outputStream.flush();

                byte[] cache = new byte[20];
                inputStream.read(cache);
                System.out.println("服务端发过来的数据是：" + new String(cache));
            }
            // 关闭socket
//            inputStream.close();
//            outputStream.close();
//            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
