package homework1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerThread implements Runnable{
    private Socket socket;
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
    public ServerThread(Socket socket) {
        this.socket=socket;
    }

    @Override
    public void run() {

        String ip = socket.getInetAddress().getHostAddress();
        byte[] cache = new byte[100];

        try {
            InputStream inputStream = socket.getInputStream();

            while(true){
                inputStream.read(cache);

                Date now = new Date();

                System.out.println(simpleDateFormat.format(now)+" "+ip + ":收到心跳");
                MyServer.map.put(ip, simpleDateFormat.format(now));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
