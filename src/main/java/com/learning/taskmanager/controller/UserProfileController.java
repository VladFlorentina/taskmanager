package com.learning.taskmanager.controller;

import com.learning.taskmanager.service.UserProfileService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
public class UserProfileController {
    private final UserProfileService profileService;

    public UserProfileController(UserProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping("/demo")
    public String createUserWithProfile(){
        Long userId=profileService.createUserWithProfile();

        return "created user with id : "+userId+" and a profile";
    }

    @PostMapping("/cascade-demo")
    public String createCascadeDemo(){
        Long userId=profileService.createUserWithCascade();

        return "created user with cascade , id "+userId;
    }
}
