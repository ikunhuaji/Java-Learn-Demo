package ex4;

import java.util.LinkedList;
import java.util.List;

/**
 * VM参数：
 * -Xms1000M -Xmx1000M -XX:+PrintGCDetails
 * -XX:+PrintGCDetails -XX:+UseSerialGC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC
 * -XX:+PrintGCDetails -XX:+UseG1GC
 */
public class TestGC {

    /*不停往list中填充数据*/
    //就使用不断的填充 堆 -- 触发GC
    public static class FillListThread extends Thread{
        List<Object> list = new LinkedList<>();

        @Override
        public void run() {
            try {
                while(true){
//                    if(list.size()*512/1024/1024>=512){
//                        list.clear();
//                        System.out.println("list is clear");
//                    }
                    byte[] bl;
                    for(int i=0;i<100;i++){
                        bl = new byte[512];
                        list.add(bl);
                    }
                    Thread.sleep(1);
                }

            } catch (Exception e) {
            }
        }
    }

    /*每100ms定时打印*/
    public static class TimerThread extends Thread{
        public final static long startTime = System.currentTimeMillis();
        @Override
        public void run() {
            try {
                while(true){
                    long t =  System.currentTimeMillis()-startTime;
                   // System.out.println(t/1000+"."+t%1000);
                    Thread.sleep(100); //0.1s
                }

            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        //填充对象线程和打印线程同时启动
        FillListThread myThread = new FillListThread(); //造成GC，造成STW
        TimerThread timerThread = new TimerThread(); //时间打印线程
        myThread.start();
        timerThread.start();
    }

}
