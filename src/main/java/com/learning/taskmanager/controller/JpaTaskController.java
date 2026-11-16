package com.learning.taskmanager.controller;

import com.learning.taskmanager.entity.Task;
import com.learning.taskmanager.entity.TaskStatus;
import com.learning.taskmanager.service.JpaTaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class JpaTaskController {

    private final JpaTaskService taskService;

    public JpaTaskController(JpaTaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task.getTitle(),task.getDescription());
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @GetMapping("/search")
    public List<Task> searchTasks(@RequestParam String title){
        return taskService.getTasksByTitle(title);
    }

    @PutMapping("/{id}/status")
    public Task updateStatus(
            @PathVariable Long id,
            @RequestParam TaskStatus status) {

        return taskService.updateTaskStatus(id, status);
    }
}
