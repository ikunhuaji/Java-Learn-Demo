package demo4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyClient {
    public static void main(String[] args) {
        try{
            DatagramSocket datagramSocket = new DatagramSocket(888);

            String s = "HELLO WORLD";

            DatagramPacket datagramPacket = new DatagramPacket(s.getBytes(),s.getBytes().length, InetAddress.getLocalHost(),8888);

            datagramSocket.send(datagramPacket);

            byte[] cache = new byte[20];
            DatagramPacket rec = new DatagramPacket(cache,cache.length);

            datagramSocket.receive(rec);

            System.out.println(new String(rec.getData()).trim());

            datagramSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
