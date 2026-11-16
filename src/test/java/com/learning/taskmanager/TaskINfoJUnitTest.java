package com.learning.taskmanager;

import com.learning.taskmanager.model.TaskInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskINfoJUnitTest {

    private TaskInfo taskInfo;

    @BeforeEach
    void setUp() {
        taskInfo = new TaskInfo();
        taskInfo.setTitle("Learn Testing");
        taskInfo.setDescription("JUnit practice");

        System.out.println("Pregatim datele pentru test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Testul s-a terminat");
    }

    @Test
    void shouldHaveCorrectTaskInformation() {
        assertAll(
                () -> assertEquals("Learn Testing",
                        taskInfo.getTitle()),

                () -> assertEquals("JUnit practice",
                        taskInfo.getDescription()),

                () -> assertNotNull(taskInfo)
        );
    }

    @Test
    void shouldAllowChangingTitle() {
        taskInfo.setTitle("Learn Mockito");

        assertEquals("Learn Mockito",
                taskInfo.getTitle());
    }

    @Test
    void shouldAllowNullDescription() {
        taskInfo.setDescription(null);

        assertNull(taskInfo.getDescription());
    }

}
