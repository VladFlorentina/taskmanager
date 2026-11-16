package com.learning.taskmanager.controller;

import com.learning.taskmanager.service.JpaTaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LomboDemoController {

    private final JpaTaskService taskService;

    @GetMapping("/lombok-demo")
    public String showLomboDemo(){
        log.info("a fost accesat endpoint ul /lombok-demo");
        int numberOfTasks=taskService.getTasks().size();
        log.info("nr de tasjuri gasite :{}",numberOfTasks);

        return "Lombok functioneaza ! nr de taskuri: "+numberOfTasks;
    }
}
