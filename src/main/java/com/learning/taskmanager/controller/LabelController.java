package com.learning.taskmanager.controller;

import com.learning.taskmanager.service.LabelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/labels")
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @PostMapping("/demo")
    public String createDemo() {
        Long taskId = labelService.createTaskWithLabels();

        return "Created task with ID: " + taskId
                + " and 2 labels";
    }
}