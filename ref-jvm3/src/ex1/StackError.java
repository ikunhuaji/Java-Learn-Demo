package ex1;
/**
 * @author King老师
 * 虚拟机栈溢出 -Xss1m
 */
public class StackError {
    public static void main(String[] args) {
        A();
    }
    public static void A(){
        A();//死递归  栈帧不断 A不断入栈，不会出栈
    }
}
