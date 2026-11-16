package com.learning.taskmanager.service;

import com.learning.taskmanager.entity.Task;
import com.learning.taskmanager.entity.User;
import com.learning.taskmanager.repository.TaskREpositoty;
import com.learning.taskmanager.repository.UserRepositoty;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepositoty userRepositoty;
    private final TaskREpositoty taskREpositoty;

    public UserService(UserRepositoty userRepositoty, TaskREpositoty taskREpositoty) {
        this.userRepositoty = userRepositoty;
        this.taskREpositoty = taskREpositoty;
    }

    public Long createUserWithTasks(){
        User user=new User ("Alex","alexandru@gamil.com");
        userRepositoty.save(user);

        Task task=new Task("task1 ","understand repositories");
        Task task2=new Task("task2","undersand entity relationship");

        user.addTask(task);
        user.addTask(task2);

        taskREpositoty.save(task);
        taskREpositoty.save(task2);
        return user.getId();
    }
}
