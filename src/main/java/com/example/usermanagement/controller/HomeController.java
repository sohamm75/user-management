package com.example.usermanagement.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String home() throws Exception {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "live");
        response.put("message", "User Management API is up and running.");
        response.put("description", "Spring Boot + JWT + Role-Based Access Control (USER, MANAGER, ADMIN)");
        response.put("how_to_test", "Use Postman to call the endpoints below.");

        Map<String, String> endpoints = new LinkedHashMap<>();
        endpoints.put("POST /api/auth/register", "Register a new user");
        endpoints.put("POST /api/auth/login", "Login and receive a JWT token");
        endpoints.put("GET /api/user/profile", "Get logged-in user profile (requires Bearer token)");
        endpoints.put("GET /api/user/tasks", "Get tasks assigned to logged-in user (requires Bearer token)");
        endpoints.put("GET /api/manager/users", "View all users (MANAGER role required)");
        endpoints.put("GET /api/admin/users", "View all users (ADMIN role required)");

        response.put("endpoints", endpoints);
        response.put("github", "https://github.com/sohamm75/user-management");

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper.writeValueAsString(response);
    }
}