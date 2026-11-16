package com.learning.taskmanager.controller;

import com.learning.taskmanager.model.Appinfo;
import com.learning.taskmanager.service.InMemoryTaskService;
import com.learning.taskmanager.service.TaskSErvice;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    //dependency injection
    private final TaskSErvice taskservice;
    private final Appinfo appinfo;


    //contructor injection
    public TaskController(@Qualifier("demoTaskService") TaskSErvice taskservice, Appinfo appinfo) {
        this.taskservice = taskservice;
        this.appinfo=appinfo;
    }


    //cand primesti o cerere http get catre tasks executa asta
    @GetMapping("/tasks")
    public String getTasks(){
        return taskservice.getAllTasks();
    }

    @GetMapping("/app-info")
    public String getAppInfo(){
        return appinfo.getName();
    }

}
