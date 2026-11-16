
package com.learning.taskmanager.controller;

import com.learning.taskmanager.service.JpaTaskService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class TaskPageControllerTest {

    private MockMvc mockMvc;
    private JpaTaskService taskService;

    @BeforeEach
    void setUp() {

        taskService = mock(JpaTaskService.class);

        TaskPageController controller =
                new TaskPageController(taskService);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void shouldDisplayTasksPage() throws Exception {

        when(taskService.getTasks())
                .thenReturn(List.of());

        mockMvc.perform(get("/tasks-view"))
                .andExpect(status().isOk())
                .andExpect(view().name("tasks"))
                .andExpect(model().attributeExists("tasks"))
                .andExpect(model().attributeExists("newTask"));

        verify(taskService).getTasks();
    }

    @Test
    void shouldCreateTaskAndRedirect() throws Exception {

        mockMvc.perform(post("/tasks-view")
                        .param("title", "Learn MockMvc")
                        .param("description", "Testing POST request"))

                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/tasks-view"));

        verify(taskService).createTask(
                "Learn MockMvc",
                "Testing POST request"
        );
    }
}
