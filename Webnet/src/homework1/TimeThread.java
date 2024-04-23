package homework1;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread implements Runnable{
    private Socket socket;

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

    String data;

    public TimeThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        Date date = new Date();
        MyServer.map.put(socket.getInetAddress().getHostAddress(),simpleDateFormat.format(date));

        String ip = socket.getInetAddress().getHostAddress();

        while(true){
            try {
                data = MyServer.map.get(ip);

                try {
                    Thread.sleep(20000);
                }catch (Exception e){
                    e.printStackTrace();
                }

                if(data.equals(MyServer.map.get(ip))){
                    System.out.println(ip + " 出现问题");
                    socket.close();
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
