package com.learning.taskmanager.controller;

import com.learning.taskmanager.service.XmlGreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XmlDemoController {

    private final XmlGreetingService greetingService;

    public XmlDemoController(
            @Qualifier("xmlGreetingService")
            XmlGreetingService greetingService) {

        this.greetingService = greetingService;
    }
    @GetMapping("/xml-demo")
    public String showXmlMessage() {
        return greetingService.getMessage();
    }
}
