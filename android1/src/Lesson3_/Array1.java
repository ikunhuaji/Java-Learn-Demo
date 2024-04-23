package Lesson3_;

import java.io.Serializable;
import java.util.ArrayList;

public class Array1 {
//    public static <T> T min(T a,T b){
//        if(a.compareTo(b)>0)return a ;
//        else return b;
//    }

    public static <T extends ArrayList&Comparable&Serializable> T min(T a, T b){
        if(a.compareTo(b)>0)return a ;
        else return b;
    }//JDK中的min函数重写
    //泛型可以继承类和实现接口，但父类只能一个，同时父类写到最前面
    static class Test{};

    public static void main(String[] args) {
//        Array1.min(new Test(),new Test());  报错不符合比较类型的参数
    }
}
