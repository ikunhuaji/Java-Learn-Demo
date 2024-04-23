package D2024_03_05.BUY;

public class SyncTest{
    public static void main(String args[]){
        SyncStack stack = new SyncStack();
        Runnable source=new Producer(stack);
        Runnable sink = new Consumer(stack);
        Thread t1 = new Thread(source);
        Thread t2 = new Thread(sink);
        t1.start();
        t2.start();
    }
}
