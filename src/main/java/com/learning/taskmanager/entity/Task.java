package com.learning.taskmanager.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")//cheia externa
    private User user;


    @ManyToMany
    @JoinTable(name="task_labels", joinColumns = @JoinColumn(name="task_id"),inverseJoinColumns = @JoinColumn(name="label_id"))
    private Set<Label> labels=new HashSet<>();

    @Enumerated(EnumType.STRING)
    private TaskStatus status=TaskStatus.TODO;

    public Task(){

    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Label>getLabels(){
        return labels;
    }
    public void  addLabel(Label label){
        labels.add(label);
    }

    public TaskStatus getStatus(){
        return status;
    }

    public void setStatus(TaskStatus status){
        this.status=status;
    }
}
