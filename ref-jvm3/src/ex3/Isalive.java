package ex3;
/**
 * @author  King老师
 * VM Args：-XX:+PrintGC
 * 判断对象存活
 */
public class Isalive {
    public Object instance =null;
    //占据10M内存，便于判断分析GC
    private byte[] bigSize = new byte[10*1024*1024];

    public static void main(String[] args) {
        Isalive objectA = new Isalive();//objectA 局部变量表 GCRoots
        Isalive objectB = new Isalive();//objectB 局部变量表
        //相互引用
        objectA.instance = objectB; //强引用
        objectB.instance = objectA;
        //切断可达
        objectA =null;
        objectB =null;
        //强制垃圾回收，能够回收走1， 不能回收走2
        System.gc();
    }
}
