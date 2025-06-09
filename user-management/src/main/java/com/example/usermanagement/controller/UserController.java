package com.example.usermanagement.controller;

import com.example.usermanagement.entity.Task;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.TaskRepository;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
//@PreAuthorize("hasAnyRole('USER', 'ADMIN', 'MANAGER')")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    // ✅ Get current user's profile
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return ResponseEntity.ok(user);
    }

    // ✅ Get current user's tasks
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getMyTasks(Authentication authentication) {
        String email = authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Task> tasks = taskRepository.findByAssignedTo(user);
        return ResponseEntity.ok(tasks);
    }
}
