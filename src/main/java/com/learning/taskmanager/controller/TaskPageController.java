package com.learning.taskmanager.controller;


import com.learning.taskmanager.entity.Task;
import com.learning.taskmanager.service.JpaTaskService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class TaskPageController {
    private final JpaTaskService taskService;

    @Value("${app.page-message}")
    private String pageMessage;

    @Value("${company.name}")
    private String companyName;

    public TaskPageController(JpaTaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks-view")
    public String showTask(Model model){
        model.addAttribute("tasks",taskService.getTasks());
        model.addAttribute("newTask",new Task());

        model.addAttribute("pageMessage",pageMessage);
        model.addAttribute("companyName",companyName);

        return "tasks";
    }
    @PostMapping("/tasks-view")
    public String createTask(@ModelAttribute("newTask") Task task){
        taskService.createTask(task.getTitle(),task.getDescription());

        return "redirect:/tasks-view";
    }
}
