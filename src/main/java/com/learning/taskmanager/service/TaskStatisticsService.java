package com.learning.taskmanager.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class TaskStatisticsService {

    public TaskStatisticsService() {
        System.out.println("TaskStatisticsService created! ");
    }

    //metoda este apelata dupa ce spring a creat beanul
    @PostConstruct
    public void init(){
        System.out.println("TaskStatisticsService initialized");
    }

    public String getStatistics(){
        return "Task manager statistics";
    }

    //metoda este apelata inainte ca spring sa distruga un beean gestionat
    @PreDestroy
    public void cleanup(){
        System.out.println("TaskStatisticsService is being destoyed");
    }
}
