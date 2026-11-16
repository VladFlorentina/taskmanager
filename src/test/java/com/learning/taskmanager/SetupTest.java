package com.learning.taskmanager;

import com.learning.taskmanager.model.TaskInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetupTest {

    @Test
    void shouldRunJUnitTest() {

        int result = 2 + 2;

        assertEquals(4, result);
    }

    @Test
    void shouldGenerateGetterAndSetterWithLombok(){
        TaskInfo taskInfo = new TaskInfo();

        taskInfo.setTitle("Learn Lombok");
        taskInfo.setDescription("understand annotations");

        assertEquals("Learn Lombok", taskInfo.getTitle());
        assertEquals("understand annotations", taskInfo.getDescription());
    }

    @Test
    void shouldCreateTaskInfoUsingConstructor() {

        TaskInfo taskInfo = new TaskInfo(
                "Learn Lombok",
                "Understand constructors"
        );

        assertEquals("Learn Lombok", taskInfo.getTitle());
        assertEquals("Understand constructors", taskInfo.getDescription());
    }

    @Test
    void shouldCreateTaskInfoUsingBuilder() {

        TaskInfo taskInfo = TaskInfo.builder()
                .title("Learn Lombok")
                .description("Understand Builder")
                .build();

        assertEquals("Learn Lombok", taskInfo.getTitle());
        assertEquals("Understand Builder", taskInfo.getDescription());
    }

    @Test
    void shouldGenerateToStringWithLombok() {

        TaskInfo taskInfo = new TaskInfo(
                "Learn Lombok",
                "Understand annotations"
        );

        String result = taskInfo.toString();

        assertTrue(result.contains("Learn Lombok"));
        assertTrue(result.contains("Understand annotations"));
    }

    @Test
    void shouldGenerateEqualsAndHashCodeWithLombok() {

        TaskInfo task1 = new TaskInfo("Java", "Learn Java");
        TaskInfo task2 = new TaskInfo("Java", "Learn Java");

        assertEquals(task1, task2);
        assertEquals(task1.hashCode(), task2.hashCode());
    }

}