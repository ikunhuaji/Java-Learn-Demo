package pack1;

public class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        outerClass.show(55);



//        OuterClass.InnerClass innerClass1 = new OuterClass.InnerClass();
//        如果 InnerClass 是static的静态，就能使用这个方法直接实例化
    }
}