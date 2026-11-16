package com.learning.taskmanager.controller;

import com.learning.taskmanager.service.XmlGreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FactoryDemoController {

    private final XmlGreetingService greetingService;

    public FactoryDemoController(
            @Qualifier("factoryGreetingService")
            XmlGreetingService greetingService) {

        this.greetingService = greetingService;
    }

    @GetMapping("/factory-demo")
    public String showMessage() {
        return greetingService.getMessage();
    }
}