package demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread2 implements Runnable{
    private Socket socket;

    public ServerThread2(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {
        try {

            System.out.println("启动服务器");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            while (true){
                byte[] cache = new byte[100];
                inputStream.read(cache);
                if(new String(cache).startsWith("exit")){
                    outputStream.write("exit".getBytes());
                    break;
                }

                System.out.println("客户端发来：" + new String(cache));
                outputStream.write("received".getBytes());
            }

            socket.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
