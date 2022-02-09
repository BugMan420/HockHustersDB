package com.example.tsi.izzy.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Category {

    @Id
    @GeneratedValue
    private int category_id;
    private String name;

    public Category(String name){
        this.name=name;
    }

    public Category(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }



}
