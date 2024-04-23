package pack1;

public class OuterClass {

    static int ss=0;
    class InnerClass {//成员内部类
        InnerClass(){
            System.out.println("Inner Class");
        }
    }

    private int num3=10;
    public void show(final int num2){

        int num1=10;
        class InnerClass2 {   //局部内部类
            public void display()
            {
                System.out.println(num1);//默认final

                int s=22;
                System.out.println(s);

                num3++;
                System.out.println(num3);

                System.out.println(num2);//局部内部类的外部函数的形参与变量都为final
            }
        }
        InnerClass2 innerClass2 = new InnerClass2();
        innerClass2.display();
    }

}


