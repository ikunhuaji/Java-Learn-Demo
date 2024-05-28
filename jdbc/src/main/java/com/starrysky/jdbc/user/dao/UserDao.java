package com.starrysky.jdbc.user.dao;

import java.sql.*;

public class UserDao {
    public boolean findByNameAndPwd(String name,String pwd){

        Statement sm = null;
        Connection con = null;
        ResultSet rs =null;

        //加载驱动
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }


        try{
            //获取数据库连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cakeonline_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
                    "root",
                    "xjl13615875481"
            );

            //执行sql语句
            String sql = "select * from user_tb where name = '"+name+"' and pwd = '"+pwd+"'";

            sm = con.createStatement();

            //查找
            rs = sm.executeQuery(sql);

            if(rs!=null&&rs.next()){
                return true;
            }
            else return false;

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
