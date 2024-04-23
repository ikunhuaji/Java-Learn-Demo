package demo2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket =new ServerSocket(8888);


            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("监听到客户端");
                new Thread(new ServerThread2(socket)).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
