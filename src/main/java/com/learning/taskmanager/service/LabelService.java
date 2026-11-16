package com.learning.taskmanager.service;

import com.learning.taskmanager.entity.Label;
import com.learning.taskmanager.entity.Task;
import com.learning.taskmanager.repository.LabelREpository;
import com.learning.taskmanager.repository.TaskREpositoty;
import org.springframework.stereotype.Service;

@Service
public class LabelService {
    private final LabelREpository labelRepository;
    private final TaskREpositoty taskRepository;

    public LabelService(LabelREpository labelRepository, TaskREpositoty taskRepository) {
        this.labelRepository = labelRepository;
        this.taskRepository = taskRepository;
    }

    public Long createTaskWithLabels() {

        Label java = labelRepository.save(new Label("Java"));
        Label backend = labelRepository.save(new Label("Backend"));

        Task task = new Task(
                "Learn Spring",
                "Understand ManyToMany relationships"
        );

        task.addLabel(java);
        task.addLabel(backend);

        taskRepository.save(task);

        return task.getId();
    }
}
