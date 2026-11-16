package com.learning.taskmanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name="labels")
public class Label extends BaseEntity {


    private String name;
    public Label(){

    }

    public Label(String name){
        this.name=name;
    }


    public String getName() {
        return name;
    }
}
