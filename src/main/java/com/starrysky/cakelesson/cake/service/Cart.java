package com.starrysky.cakelesson.cake.service;

import com.starrysky.cakelesson.entity.Cake;

import java.util.HashMap;

public class Cart {
    private HashMap<Integer,CartItem>map = new HashMap<>();

    public void addCake(Cake cake){
        if(map.containsKey(cake.getId())){
            CartItem cartItem = map.get(cake.getId());
            cartItem.setCount(cartItem.getCount()+1);
            map.put(cake.getId(),cartItem);
        }
        else{
            CartItem cartItem = new CartItem();
            cartItem.setCake(cake);
            cartItem.setCount(1);
            map.put(cake.getId(),cartItem);
        }
    }

    public HashMap<Integer,CartItem> getMap(){
        return map;
    }
}
