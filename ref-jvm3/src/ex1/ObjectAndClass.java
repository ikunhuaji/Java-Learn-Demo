package ex1;

import java.nio.ByteBuffer;

/**
 * @author King老师
 *代码和对象是如何在JVM中分配
 **/
public class ObjectAndClass {
    static int age=18;//todo 静态变量（基本数据类型）
    final static int sex=1;//todo 常量（基本数据类型）
    final  static  ObjectAndClass object = new ObjectAndClass();//todo 成员变量指向（对象）在类加载的时候不会执行
    //构造方法  -》ObjectAndClass object = new ObjectAndClass();
    private boolean isKing;//todo 成员变量 放在哪里？？？

    public   static void main(String[] args) {//启动一个线程，创建一个虚拟机栈，数据结构，单个，压入一个栈帧
        int x=18;//todo 局部变量（基本数据类型）
         long y=1;//todo 局部变量（基本数据类型）
         ObjectAndClass lobject = new ObjectAndClass();//todo 局部变量 引用  （对象）
         lobject.isKing=true;// isKing跟随对象，堆空间
         lobject.hashCode();//方法中调用方法  本地方法（C++语言写  JNI）
         ByteBuffer bb = ByteBuffer.allocateDirect(128*1024*1024);//todo 直接分配128M的直接内存
        //这个地方 分配在哪里  128M
    }
}
