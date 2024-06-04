package com.starrysky.jdbc;

import com.starrysky.jdbc.user.dao.UserDao;
import com.starrysky.jdbc.user.service.UserService;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        //加载驱动
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        try{
            //获取数据库连接
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cakeonline_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
                    "root",
                    "xjl13615875481"
            );

            //执行sql语句
            String sql1 = "insert into cakeinfo values('m4',20,0,'what can I say?')";
            String sql2 = "select * from cakeinfo";
            Statement sm = con.createStatement();

            //插入数据
//            int count = sm.executeUpdate(sql1);
//            System.out.println(count);

            //查找
            ResultSet rs = sm.executeQuery(sql2);

            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(1);
                int price = rs.getInt(2);
                String info = rs.getString(4);

                System.out.println("id:" + id +"; name:"+ name + "; price:" + price + "; info:" + info);
            }

            //关闭连接
            sm.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }


        System.out.println(new UserService().login("lisi", "1919810"));

    }
}
