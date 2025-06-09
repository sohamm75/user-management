package com.example.usermanagement;

import com.example.usermanagement.entity.Role;
import com.example.usermanagement.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        List<String> roleNames = Arrays.asList("ADMIN", "MANAGER", "USER");

        for (String roleName : roleNames) {
            roleRepository.findByName(roleName).orElseGet(() -> {
                Role role = new Role();
                role.setName(roleName);
                return roleRepository.save(role);
            });
        }
    }
}
