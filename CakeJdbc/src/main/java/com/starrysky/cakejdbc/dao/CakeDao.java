package com.starrysky.cakejdbc.dao;

import com.starrysky.cakejdbc.item.Cake;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CakeDao {

    static {
        //加载驱动
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getCon(){
        try {
            //获取数据库连接
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cake_db?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8",
                    "root",
                    "xjl13615875481"
            );

            return con;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void saveCake(Cake cake){
        int id = cake.getId();
        String name = cake.getName();
        int price = cake.getPrice();
        int state = cake.getState();

        PreparedStatement ps = null;
        Connection con = getCon();
        String sql = "insert into tbl_cake values(?,?,?,?)";

        try {
            ps=con.prepareStatement(sql);

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setInt(3,price);
            ps.setInt(4,state);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(ps,con);
    }

    public List<Cake> findByNormalState(){
        List<Cake> cakes = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getCon();

        String sql = "select * from tbl_cake where state = 1";

        try {
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int price = rs.getInt(3);
                int state = rs.getInt(4);

                cakes.add(new Cake(id,name,price,state));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        close(rs,ps,con);
        return cakes;
    }

    public void updateState(int id,int state){
        PreparedStatement ps = null;
        Connection con = getCon();
        String sql = "update tbl_cake set state = ? where id = ?";

        try {
            ps=con.prepareStatement(sql);
            ps.setInt(1,state);
            ps.setInt(2,id);

            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static int getSize(){
        PreparedStatement ps = null;
        ResultSet rs = null;

        int cnt=0;
        Connection con = getCon();

        String sql = "select count(*) from tbl_cake";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            if(rs.next()){
                cnt = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(rs,ps,con);
        return  cnt;
    }

    public static void close(ResultSet rs, PreparedStatement ps,Connection con){
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
