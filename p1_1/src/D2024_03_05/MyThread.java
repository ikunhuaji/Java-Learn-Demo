package D2024_03_05;


public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.print(i);
            try {
                Thread.sleep(1000);
                System.out.print("    线程睡眠1000毫秒！\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new MyThread().start();
    }
}

