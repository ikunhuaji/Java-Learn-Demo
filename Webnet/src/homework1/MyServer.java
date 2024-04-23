package homework1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MyServer {

    public static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(8888);

            while (true){
                try{
                    Socket socket = serverSocket.accept();

                    System.out.println("连接上");


                    new Thread(new ServerThread(socket)).start();
                    new Thread(new TimeThread(socket)).start();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
