package com.learning.taskmanager.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
//@Profile("prod")
public class DemoTaskService  implements TaskSErvice{

    @Override
    public String getAllTasks() {
        return "DEMO task! learn spring configuration ";
    }
}
