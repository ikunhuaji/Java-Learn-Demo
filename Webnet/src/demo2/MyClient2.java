package demo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient2 {
    public static void main(String[] args) {
        try {
            Socket socket =new Socket("127.0.0.1",8888);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            Scanner input = new Scanner(System.in);

            while(true){
                String s = input.nextLine();
                outputStream.write(s.getBytes());

                byte[] cache = new byte[100];
                inputStream.read(cache);

                if(new String(cache).startsWith("exit")){
                    break;
                }

                System.out.println("服务端端发来：" + new String(cache));
            }

//            inputStream.close();
//            outputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
