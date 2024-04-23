package com.demo3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class CheckServer {
    public static boolean isContinue = true;
    public static HashMap<String, String> map = new HashMap<>();
    public static void main(String[] args) {
        new Thread(new TimeThread()).start();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(isContinue){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                String ip = socket.getInetAddress().getHostAddress();
                System.out.println(ip);
                InputStream inputStream = socket.getInputStream();
                byte[] cache = new byte[10];
                inputStream.read(cache);

                System.out.println(ip + "," + new String(cache));
                map.put(ip, new String(cache));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        try {
            BufferedWriter bw = null;
            bw = new BufferedWriter(new FileWriter("i:/1-ids.txt"));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                try {
                    bw.write(k + "," + v);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
