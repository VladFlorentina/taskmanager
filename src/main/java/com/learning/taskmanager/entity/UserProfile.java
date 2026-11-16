package com.learning.taskmanager.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String phone;

    @OneToOne
    @JoinColumn(name="user_id", unique = true)
    private User user;

    public UserProfile() {
    }

    public UserProfile(String bio, String phone) {
        this.bio = bio;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getBio() {
        return bio;
    }


    public String getPhone() {
        return phone;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
