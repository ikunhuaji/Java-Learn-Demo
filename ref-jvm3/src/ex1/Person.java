package ex1;

/**
 * @author King老师
 * 栈帧执行对内存区域的影响
 */
public class Person {
    public  int work()throws Exception{//一个方法对应一个栈帧
        int x =1;// iconst_1 、 istore_1
        int y =2;// iconst_2 、 istore_2
        int z =(x+y)*10;
        return  z;
    }
    public static void main(String[] args) throws Exception{
        Person person = new Person();
        person.work();  //这个  3  字节码的行号（针对 本方法偏移）
        person.hashCode();//方法属于本地方法 ---本地方法栈  4
    }
}
