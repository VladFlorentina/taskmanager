package com.learning.taskmanager.repository;

import com.learning.taskmanager.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelREpository extends JpaRepository<Label,Long> {
}
