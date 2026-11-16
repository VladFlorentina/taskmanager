
package com.learning.taskmanager.repository;

import com.learning.taskmanager.entity.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional //spring deschide o tranzactie pt fieacare test si implicit face rollback la final  deci
    //putem inclusiv verifica salvarea si stergerea fara sa pastram modificarile dupa terminarea testului
class TaskRepositoryIT {

    @Autowired
    private TaskREpositoty taskRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldSaveAndFindTask() {

        // ARRANGE
        Task task = new Task(
                "Integration Testing",
                "Saving task in H2"
        );

        // ACT
        Task savedTask = taskRepository.saveAndFlush(task);

        // ASSERT
        assertNotNull(savedTask.getId());

        Task foundTask = taskRepository
                .findById(savedTask.getId())
                .orElseThrow();

        assertEquals("Integration Testing", foundTask.getTitle());
        assertEquals("Saving task in H2", foundTask.getDescription());
    }


    @Test
    void shouldUpdateTaskTitle() {

        // ARRANGE - salvam un task
        Task task = new Task("Old Title", "Testing update");

        Task savedTask = taskRepository.saveAndFlush(task);

        Long taskId = savedTask.getId();

        // ACT - modificam titlul
        savedTask.setTitle("New Title");

        taskRepository.saveAndFlush(savedTask);

        // Golim contextul de persistenta pentru a citi din nou din H2
        entityManager.clear();

        // ASSERT - verificam valoarea salvata
        Task updatedTask = taskRepository.findById(taskId)
                .orElseThrow();

        assertEquals("New Title", updatedTask.getTitle());
    }


    @Test
    void shouldDeleteTask() {

        // ARRANGE
        Task task = new Task("Task to delete", "Testing delete");

        Task savedTask = taskRepository.saveAndFlush(task);

        Long taskId = savedTask.getId();

        // ACT
        taskRepository.deleteById(taskId);
        taskRepository.flush();

        entityManager.clear();

        // ASSERT
        assertFalse(taskRepository.findById(taskId).isPresent());
    }
}
