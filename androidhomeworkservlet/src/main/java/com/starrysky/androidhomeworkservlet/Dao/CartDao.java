package com.starrysky.androidhomeworkservlet.Dao;

import com.starrysky.androidhomeworkservlet.entity.Cart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDao {
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
    public static List<Cart> getList(String userName) {
        List<Cart> carts = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getCon();

        String sql = "select * from tbl_cart where userName = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,userName);
            rs = ps.executeQuery();

            while(rs.next()){
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int cnt = rs.getInt(4);
                String img = rs.getString(5);

                carts.add(new Cart(userName,name,price,cnt,img));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        close(rs,ps,con);

        return carts;
    }

    public static void addCart(String userName, String name, double price, int cnt, String img) {
        List<Cart> carts = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getCon();

        String sql1 = "select * from tbl_cart where userName = ? and name = ?";
        String sql2 = "insert into tbl_cart values(?,?,?,?,?)";
        String sql3 = "update tbl_cart set cnt = cnt + ? where userName = ? and name = ?";

        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1,userName);
            ps.setString(2,name);
            rs = ps.executeQuery();

            if(rs.next()){
                ps = con.prepareStatement(sql3);
                ps.setInt(1,cnt);
                ps.setString(2,userName);
                ps.setString(3,name);

                ps.executeUpdate();
            }else{
                ps = con.prepareStatement(sql2);
                ps.setString(1,userName);
                ps.setString(2,name);
                ps.setDouble(3,price);
                ps.setInt(4,cnt);
                ps.setString(5,img);
                ps.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        close(rs,ps,con);
    }

    public static void addCartCnt(String userName, String name,int cnt) {
        PreparedStatement ps = null;
        Connection con = getCon();

        String sql = "update tbl_cart set cnt = cnt + ? where userName = ? and name = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,cnt);
            ps.setString(2,userName);
            ps.setString(3,name);

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        close(ps,con);
    }

    public static void deleteCart(String userName, String name) {
        PreparedStatement ps = null;
        Connection con = getCon();

        String sql = "delete from tbl_cart where userName = ? and name = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,userName);
            ps.setString(2,name);

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        close(ps,con);
    }

    public static void clearCart(String userName) {
        PreparedStatement ps = null;
        Connection con = getCon();

        String sql = "delete from tbl_cart where userName = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,userName);

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
