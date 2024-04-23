package pack1;

public class Main {
    public static void main(String[] args) {
       Demo demo1 = new Demo();
       Demo demo2 =new Demo();

//       Demo.cn1();
//       demo1.cn1();
//        可以用类名，也可用对象名访问静态方法

       demo1.show1();
       demo2.show1();

//       Demo.num=3;
//       demo1.num=3;
//       造成的结果相同，因为Demo的num是static，对于它的改变会作用到所有这类的实例化对象

//        System.out.println(demo1.num);
//        System.out.println(demo2.num);
    }
}