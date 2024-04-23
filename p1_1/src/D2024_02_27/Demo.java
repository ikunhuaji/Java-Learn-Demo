package D2024_02_27;

public class Demo {
    public static void main(String[] args) {

        System.out.println("begin");
        TimeThread timeThread =new TimeThread();
        timeThread.start();//使timeThread进入就绪状态启动线程，可能抢不到线程执行

        //System.out.println("end");

        //timeThread.start();不能再次运行
        new Thread(timeThread).start();//再次运行


    }
}