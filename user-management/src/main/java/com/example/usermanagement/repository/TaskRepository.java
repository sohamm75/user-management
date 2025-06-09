package com.example.usermanagement.repository;

import com.example.usermanagement.entity.Task;
import com.example.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAssignedTo(User user);
}
