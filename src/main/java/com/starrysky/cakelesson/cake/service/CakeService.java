package com.starrysky.cakelesson.cake.service;

import com.starrysky.cakelesson.cake.dao.CakeDao;
import com.starrysky.cakelesson.entity.Cake;

import java.util.List;

public class CakeService {
    public void addCake(Cake cake){
        new CakeDao().saveCake(cake);
    }

    public List<Cake> listAll(){
        return new CakeDao().findAll();
    }
    public void removeCake(int id){
        new CakeDao().deleteCake(id);
    }
}
