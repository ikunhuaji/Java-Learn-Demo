package homework1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;


public class MyClient2 {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);

            OutputStream outputStream = socket.getOutputStream();

            while(true){
                try{
                    Thread.sleep(10000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                outputStream.write("1".getBytes());
                outputStream.flush();
            }
        }catch (IOException e){
             e.printStackTrace();
        }
    }
}
