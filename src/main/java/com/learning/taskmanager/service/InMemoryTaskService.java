package com.learning.taskmanager.service;


import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

//daca ai nevoie de mai multe beenuri prefera aceasta
@Primary
//service contine logica aplicatiei
@Service
//@Profile("dev")
public class InMemoryTaskService implements TaskSErvice{

    @Override
    public String getAllTasks() {
        return "Task 1: learn Spring boot!  ";
    }
}

