package com.starrysky.androidhomeworkservlet.Dao;

import com.starrysky.androidhomeworkservlet.entity.TotalBuy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TotalBuyDao {
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

    public static List<TotalBuy> getList(String userName){
        List<TotalBuy>totalBuys = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getCon();

        String sql = "select * from tbl_totalbuy where userName = ?";

        try {
            ps=con.prepareStatement(sql);
            ps.setString(1,userName);
            rs = ps.executeQuery();

            while(rs.next()){
                String buyTime = rs.getString(2);
                double totalPrice = rs.getDouble(3);

                totalBuys.add(new TotalBuy(userName,buyTime,totalPrice));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        close(rs,ps,con);

        return totalBuys;
    }

    public static void add(String userName, String buyTime, double totalPrice) {
        PreparedStatement ps = null;
        Connection con = getCon();

        String sql = "insert into tbl_totalbuy values(?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,buyTime);
            ps.setDouble(3,totalPrice);
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
