package com.starrysky.cakelesson.cake.dao;

import com.starrysky.cakelesson.db.Db;
import com.starrysky.cakelesson.entity.Cake;

import java.util.ArrayList;
import java.util.List;

public class CakeDao {
    public void saveCake(Cake cake){
        cake.setId(Db.list.size()+1);
        Db.list.add(cake);

        System.out.println(Db.list.size());
    }
    public void update(Cake cake){

    }
    public List<Cake> findAll(){
        return Db.list;
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
