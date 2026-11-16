package com.learning.taskmanager.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;


    @OneToMany(mappedBy = "user")
    private List<Task> tasks=new ArrayList<>();


    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task){
        tasks.add(task);
        task.setUser(this);
    }

    @OneToOne(mappedBy = "user", cascade=CascadeType.PERSIST)
    private UserProfile profile;

    public  UserProfile getProfile(){
        return profile;
    }

    public void setProfile(UserProfile profile){
        this.profile=profile;

        if(profile!=null){
            profile.setUser(this);
        }
    }
}
