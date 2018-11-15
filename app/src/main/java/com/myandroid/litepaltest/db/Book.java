package com.myandroid.litepaltest.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Huochai on 2018/10/27.
 */

public class Book extends DataSupport {
    private int id;
    private String author;
    private String name;
    private int pages;
    private double price;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return author;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPages(int pages){
        this.pages = pages;
    }
    public int getPages(){
        return pages;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
}
