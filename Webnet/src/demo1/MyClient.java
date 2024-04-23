package demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        try {
            Socket socket =new Socket("127.0.0.1",8888);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] cache = new byte[20];
            inputStream.read(cache);
            System.out.println("服务端发来:"+new String(cache));

            outputStream.write("hello world".getBytes());
            outputStream.flush();

            inputStream.close();
            outputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
