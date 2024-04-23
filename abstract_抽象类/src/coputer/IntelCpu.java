package coputer;

public class IntelCpu implements Cpu ,interFace//可接多个接口
{
    @Override
    public void run() {
        System.out.println("INTEL CPU is running");
    }

    @Override
    public void print() {

    }
}
