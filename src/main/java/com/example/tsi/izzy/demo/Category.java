package com.example.tsi.izzy.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int category_id;
    private String name;

    @ManyToMany(mappedBy = "actor", fetch = FetchType.LAZY)
    private Set<Film> films = new HashSet<>();

    public Category(String name){
        this.name=name;
    }

    public Category(){}

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
