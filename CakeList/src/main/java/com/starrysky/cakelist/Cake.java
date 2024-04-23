package com.starrysky.cakelist;

public class Cake{
    public String name;
    public String size;
    public String color;

    public Cake(String name,String size,String color){
        this.name=name;
        this.size=size;
        this.color=color;
    }

    public void show(){
        System.out.println(name + " " + size + " " + color);
    }

    public String showcake(){
        return (String)(name + " " + size + " " + color) ;
    }

}
