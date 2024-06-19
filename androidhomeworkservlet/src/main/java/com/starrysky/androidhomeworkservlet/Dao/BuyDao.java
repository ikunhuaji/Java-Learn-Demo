package com.starrysky.androidhomeworkservlet.Dao;

import com.starrysky.androidhomeworkservlet.entity.Buy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuyDao {
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homework_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
                    "root",
                    "xjl13615875481"
            );

            return con;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public static List<Buy> getList(String userName,String buyTime){
        List<Buy>buys = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getCon();

        String sql = "select * from tbl_buy where userName = ? and buyTime = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,buyTime);
            rs = ps.executeQuery();

            while(rs.next()){
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int cnt = rs.getInt(4);
                String img = rs.getString(5);

                buys.add(new Buy(userName,name,price,cnt,img,buyTime));
            }

            buys.size();

        }catch (SQLException e){
            e.printStackTrace();
        }

        close(rs,ps,con);
        return buys;
    }

    public static void add(String userName, String name, double price, int cnt, String img, String buyTime) {
        PreparedStatement ps = null;
        Connection con = getCon();

        String sql = "insert into tbl_buy values(?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,name);
            ps.setDouble(3,price);
            ps.setInt(4,cnt);
            ps.setString(5,img);
            ps.setString(6,buyTime);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        close(ps,con);
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection con){
        try {
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps,Connection con){
        try {
            if(ps!=null){
                ps.close();
            }
            if(con!=null){
                con.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
