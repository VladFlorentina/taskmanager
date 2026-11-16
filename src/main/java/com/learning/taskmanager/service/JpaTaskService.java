package com.learning.taskmanager.service;

import com.learning.taskmanager.entity.Task;
import com.learning.taskmanager.entity.TaskStatus;
import com.learning.taskmanager.repository.TaskREpositoty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaTaskService {
    private final TaskREpositoty taskREpositoty;

    public JpaTaskService(TaskREpositoty taskREpositoty) {
        this.taskREpositoty = taskREpositoty;
    }

    public Task createTask(String title, String description){
        Task task=new Task(title,description);
        return taskREpositoty.save(task);
    }

    public List<Task> getTasks(){
        return taskREpositoty.findAll();
    }

    public Task getTaskById(Long id){
        return taskREpositoty.findById(id).orElse(null);
    }

    public List<Task>getTasksByTitle(String title){
        return taskREpositoty.findByTitle(title);
    }

    public Task updateTaskStatus(Long id, TaskStatus status){
        Task task = taskREpositoty.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Task not found")
                );

        task.setStatus(status);

        return taskREpositoty.save(task);
    }
}
