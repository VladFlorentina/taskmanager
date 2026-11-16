package com.learning.taskmanager.controller;

import com.learning.taskmanager.service.TaskReport;
import com.learning.taskmanager.service.TaskStatisticsService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskStatisticsController {

    private final TaskStatisticsService statisticsService;
    private final ObjectProvider<TaskReport> reportProvider;

    public TaskStatisticsController(TaskStatisticsService statisticsService, ObjectProvider<TaskReport> reportProvider) {
        this.statisticsService = statisticsService;
        this.reportProvider = reportProvider;
    }

    @GetMapping("/statistics")
    public String getStatistics(){
        return statisticsService.getStatistics();
    }

    @GetMapping("/report")
    public String generateRepor(){
        TaskReport report=reportProvider.getObject();
        return "generated report: "+report.getReortID();
    }
}
