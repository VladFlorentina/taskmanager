package com.learning.taskmanager.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class TaskReport {
    private final String reortID= UUID.randomUUID().toString();

    public String getReortID(){
        return reortID;
    }
}
