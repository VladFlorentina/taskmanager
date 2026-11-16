package com.learning.taskmanager.repository;

import com.learning.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoty extends JpaRepository<User,Long> {
}
