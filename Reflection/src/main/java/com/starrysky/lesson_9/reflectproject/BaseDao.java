package com.starrysky.lesson_9.reflectproject;

import java.lang.reflect.Field;

public class BaseDao {
    //动态生成类的 sql 语句
    public static void save(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        String sql = "insert into ";
        sql+=cls.getSimpleName()+"(";//SimpleName 无 com.starrysky……前缀


        Field[] fields = cls.getDeclaredFields();
        for(Field field:fields){
            sql+=field.getName()+",";
        }

        sql = sql.substring(0,sql.length()-1);

        sql+=") values (";

        for(Field field:fields){
            field.setAccessible(true);
            sql+=field.get(obj)+",";
        }

        sql = sql.substring(0,sql.length()-1);

        sql+=")";

        System.out.println(sql);
    }

    public static void main(String[] args) {
        Student stu = new Student();

        stu.setId(1);
        stu.setName("zhangsan");

        try {
            save(stu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
