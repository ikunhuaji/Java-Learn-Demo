package com.starrysky.lesson_9.reflectproject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectBase {

    //反射获取构造方法
    public static void showConstructor()throws Exception{
        Class cls = Student.class;
//        Constructor[] con = cls.getDeclaredConstructors();

        Constructor con = cls.getDeclaredConstructor();//无参构造
//        Constructor con = cls.getDeclaredConstructor(Integer.class);//特指单参构造

        Object o = con.newInstance();

        Student tmp = (Student) o;

        tmp.setId(1);
        System.out.println(tmp.getId());
    }

    //反射获取方法
    public static void showMethod(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        Method[] methods = cls.getDeclaredMethods();

        for(Method method:methods){
            System.out.println(method.getName());
        }

        Method setId = cls.getDeclaredMethod("setId",Integer.class);//特指一个Integer参数的setId函数
        setId.invoke(obj,100);//调用 obj 的 setId 来更改 id
    }

    //反射获取属性 更改属性值
    public static void showFiled(Object obj) throws Exception {

//        System.out.println("begin");

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        for(Field field:fields){
            System.out.println(field.getName());// 打印属性名
            field.setAccessible(true);//设置私有可访问
            Object value = field.get(obj);//获得 obj 的当前 field 属性 的值

            System.out.println(value);
        }

        Field idField = cls.getDeclaredField("id");
        idField.setAccessible(true);//设置私有可访问
        idField.set(obj,2);
    }

    public static void main(String[] args) {

        try {
            Class<?> cls = Class.forName("com.starrysky.lesson_9.reflectproject.Student");

            System.out.println(cls.getName());//获得类名
//            Object object = cls.newInstance();//实例化对象

        } catch (Exception e) {
            e.printStackTrace();
        }

        Student stu = new Student();

        stu.setId(10);
        stu.setName("zhangsan");

        System.out.println("fields:");

        try {
            showFiled(stu);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("field change:");
        System.out.println("id "+stu.getId());

        System.out.println("methods:");

        try {
            showMethod(stu);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("method change:");
        System.out.println("id "+stu.getId());

        try {
            showConstructor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
