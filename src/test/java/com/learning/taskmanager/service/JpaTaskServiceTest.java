package com.learning.taskmanager.service;

import com.learning.taskmanager.entity.Task;
import com.learning.taskmanager.entity.TaskStatus;
import com.learning.taskmanager.repository.TaskREpositoty;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.never;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class JpaTaskServiceTest {

    //creaza un obiect simulat care are metofele lui taskREpositoti, dar nu comunica cu baza de date
    @Mock
    private TaskREpositoty taskRepository;

    //creaza o instanta  de jpataskservice si ii transmite maskului repositoryul prin constructorul existent
    @InjectMocks
    private JpaTaskService taskService;

    @Test
    void shouldReturnAllTasks() {

        // ARRANGE: pregatim datele si comportamentul mock-ului
        Task task1 = new Task("Learn Mockito", "Testing services");
        Task task2 = new Task("Learn JUnit", "Testing Java");

        List<Task> expectedTasks = List.of(task1, task2);

        when(taskRepository.findAll())
                .thenReturn(expectedTasks);

        // ACT: apelam metoda pe care vrem sa o testam
        List<Task> actualTasks = taskService.getTasks();

        // ASSERT: verificam rezultatul
        assertEquals(2, actualTasks.size());
        assertEquals("Learn Mockito", actualTasks.get(0).getTitle());
        assertEquals("Learn JUnit", actualTasks.get(1).getTitle());

        // Verificam ca Repository-ul a fost apelat verifica daca metoda a fost apelata exact o data
        verify(taskRepository).findAll();
    }

    @Test
    void shouldUpdateTaskStatus(){
        //Arrange
        Task task=new Task("learn mockito","testing updates");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        when(taskRepository.save(task)).thenReturn(task);

        //ACT
        Task updateTask=taskService.updateTaskStatus(1L, TaskStatus.DONE);

        //ASSERT

        assertEquals(TaskStatus.DONE, updateTask.getStatus());
        verify(taskRepository).findById(1L);
        verify(taskRepository).save(task);
    }

    @Test
    void shouldThrowExceptionWhenTaskDoesNotExist() {

        when(taskRepository.findById(99L))
                .thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> taskService.updateTaskStatus(99L, TaskStatus.DONE)
        );

        assertEquals("Task not found", exception.getMessage());

        verify(taskRepository).findById(99L);
        verify(taskRepository, never()).save(any(Task.class));
    }


    @Test
    void shouldCaptureTaskPassedToRepository() {

        // ARRANGE
        when(taskRepository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // ACT
        Task createdTask = taskService.createTask(
                "Learn Mockito",
                "ArgumentCaptor"
        );

        // ASSERT
        ArgumentCaptor<Task> taskCaptor =
                ArgumentCaptor.forClass(Task.class);

        verify(taskRepository).save(taskCaptor.capture());

        Task capturedTask = taskCaptor.getValue();

        assertEquals("Learn Mockito", capturedTask.getTitle());
        assertEquals("ArgumentCaptor", capturedTask.getDescription());

        assertSame(capturedTask, createdTask);
    }

}
