package coputer;

public interface SubCpu extends Cpu,interFace
//接口可继承多个接口，类只能有一个父类，类可以实现多个接口,接口内只能有常量和方法
{
    int ff = 10;//不论是否加final，接口内都变为常量

    void ss();//不论是否加abstract,都为抽象类
    // JDK8 以前接口不能有{}的方法体

    default void kk()//JDK17 可使用 static 和 default 的方法体
    {
        System.out.println("KK");
    }
}
