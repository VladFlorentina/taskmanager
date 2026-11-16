package com.learning.taskmanager.controller;

import com.learning.taskmanager.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/demo")
    public String createUserWithTask(){
        Long userId=userService.createUserWithTasks();

        return "creaza user cu id "+userId+" si 2 tascuri ";
    }
}
