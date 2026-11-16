package com.learning.taskmanager.controller;

import com.learning.taskmanager.config.TaskManagerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettingsController {
    private final TaskManagerProperties properties;

    public SettingsController(TaskManagerProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/settings")
    public String getSettings(){
        return "Aplication: "+properties.appName()
                +", Max tasks: "+properties.maxtasks()
                +", notifications: "+properties.notificationsEnabled();
    }
}
