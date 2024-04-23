package pack1;

public class Demo
{
    private static int num1 =1;
    int num2=2;

    public void show()
    {
        System.out.println(num1);
        System.out.println(num2);
    }

    public static void cn1()
    {
        num1++;
    }
    public static void show1()//静态方法
    {
        System.out.println(num1);
//        System.out.println(num2);//报错：static 的函数只能调用static的变量
    }

    static int c=0;//c的初始值会因为静态代码块变成1

    Demo()
    {
        c=c+15;
    }

    Demo(int i)
    {
        c+=i;
    }

    static//静态代码块，加载类的时候执行一次
    {
        c++;
    }

//    继承执行顺序
//    子类实例化对象时的执行顺序
//    属性和代码块看定义先后
//    1.父类的静态代码块；
//    2.子类的静态代码块；
//    3.父类的构造方法；
//    4.子类的构造方法。

}
