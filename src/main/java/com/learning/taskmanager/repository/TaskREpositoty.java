package com.learning.taskmanager.repository;

import com.learning.taskmanager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskREpositoty extends JpaRepository<Task,Long> {

    List<Task> findByTitle(String title );

}
