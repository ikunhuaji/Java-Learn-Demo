package demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try{
            //构建ServerSocketd对象
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("启动服务端");
            Socket socket = serverSocket.accept();
            System.out.println("监听到客户端");

            //流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            outputStream.write("receive".getBytes());
            outputStream.flush();

            byte[] cache = new byte[20];
            inputStream.read(cache);

            System.out.println("客户端发来:"+new String(cache));

            inputStream.close();
            outputStream.close();
            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
