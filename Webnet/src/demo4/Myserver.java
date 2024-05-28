package demo4;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Myserver {
    public static void main(String[] args) {
        try{
            DatagramSocket datagramSocket = new DatagramSocket(8888);


            byte[] cache = new byte[20];
            DatagramPacket datagramPacket = new DatagramPacket(cache, cache.length);

            datagramSocket.receive(datagramPacket);

            System.out.println(new String(datagramPacket.getData()).trim());

            String s = "receive";

            DatagramPacket response = new DatagramPacket(s.getBytes(),s.getBytes().length, InetAddress.getLocalHost(),888);

            datagramSocket.send(response);

            datagramSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
