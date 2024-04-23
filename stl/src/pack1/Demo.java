package pack1;

import pack1.Stu;

import java.util.ArrayList;

public class Demo
{
    public static void main(String[] args) {
        //ArrayList
        ArrayList list = new ArrayList();
        System.out.println(list.size());

        list.add(2222222);
        list.add(0,200);
        list.add(243);
        list.add("abc");
        System.out.println(list);

        list.add(new Stu());
        Object object = list.get(2);//获得元素
        System.out.println(object);
        System.out.println(list);

        list.set(0,"kkk");//代替下标为0的元素
        System.out.println(list);

        list.remove(1);//移除元素
        System.out.println(list);

        list.remove(Integer.valueOf(243));//移除指定元素
        System.out.println(list);
        list.remove("kkk");
        System.out.println(list);
    }
}
