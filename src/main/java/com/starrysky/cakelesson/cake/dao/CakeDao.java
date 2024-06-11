package com.starrysky.cakelesson.cake.dao;

import com.starrysky.cakelesson.db.Db;
import com.starrysky.cakelesson.entity.Cake;
import com.starrysky.cakelesson.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CakeDao {
    public void saveCake(Cake cake){
        cake.setId(Db.list.size()+1);
        Db.list.add(cake);

//        System.out.println(Db.list.size());
    }
    public void update(Cake cake){

    }
    public List<Cake> findAll(){
        List<Cake>cakes = new ArrayList<>();
        Connection con=null;
        PreparedStatement ps = null;
        ResultSet rs =null;

        try {
            con= DbUtil.getCon();
            ps=con.prepareStatement("select * from tbl_cake");
            rs=ps.executeQuery();

            while(rs.next()){
                Cake cake = new Cake(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(4),
                        rs.getString(3)
                );

                cakes.add(cake);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        DbUtil.close(rs,ps,con);

        return cakes;

//        return Db.list;
    }
    public void deleteCake(int id){
        for(Cake cake:Db.list){
            if (cake.getId()==id){
                Db.list.remove(cake);
                break;
            }
        }
    }

//    public List<Cake> findByName(String name){
//
//    }
//
//    public List<Cake> findByPriceBetween(int low,int hight){
//
//    }
}
