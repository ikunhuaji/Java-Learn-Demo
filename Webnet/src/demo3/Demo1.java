package demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Demo1 {
    public static void main(String[] args) {

        try {
            Socket socket =new Socket("10.7.88.181",8888);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            //System.out.println(socket.getInetAddress().getHostAddress());


            outputStream.write("2022015484".getBytes());
            outputStream.flush();


            outputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
