package com.starrysky.androidhomeworkservlet.Dao;

import com.starrysky.androidhomeworkservlet.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
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

    public static List<Product> getList(){
        List<Product> products = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getCon();

        String sql = "select * from tbl_product";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();;

            while (rs.next()){
                String name = rs.getString(1);
                double price = rs.getDouble(2);
                int nowCnt = rs.getInt(3);
                String img = rs.getString(4);

                products.add(new Product(name,price,nowCnt,img));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        close(rs,ps,con);

        return products;
    }

    public static void add(String name,int cnt){
        PreparedStatement ps = null;
        Connection con = getCon();

        String sql = "update tbl_product set nowCnt = nowCnt + ? where name = ? ";

        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,cnt);
            ps.setString(2,name);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        close(ps,con);
    }

    public static void reduce(String name,int cnt){
        PreparedStatement ps = null;
        Connection con = getCon();

        String sql = "update tbl_product set nowCnt = nowCnt - ? where name = ? ";

        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,cnt);
            ps.setString(2,name);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        close(ps,con);
    }

    public static int getCnt(String name) {
        PreparedStatement ps = null;
        Connection con = getCon();
        ResultSet rs = null;
        int nowCnt = 0;

        String sql = "select nowCnt from tbl_cart where name = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,name);
            rs = ps.executeQuery();

            if(rs.next()){
                nowCnt = rs.getInt(1);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        close(rs,ps,con);

        return nowCnt;
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
