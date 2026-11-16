package com.learning.taskmanager.controller;

import com.learning.taskmanager.model.EnviromentMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnviromentController {

    private final EnviromentMessage enviromentMessage;

    public EnviromentController(EnviromentMessage enviromentMessage) {
        this.enviromentMessage = enviromentMessage;
    }

    @GetMapping("/enviroment")
    public String getEnviroment(){
        return enviromentMessage.getMessage();
    }
}
