package com.vinu.attendance.service;

import com.vinu.attendance.model.User;
import com.vinu.attendance.repository.UserRepository;
import com.vinu.attendance.dto.RegisterRequest;
import com.vinu.attendance.dto.LoginRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // 🔹 REGISTER
    public Map<String, Object> register(RegisterRequest request) {

        // check existing user
        User existingUser = userRepository.findByEmail(request.getEmail());

        if (existingUser != null) {
            return Map.of("error", "User already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return Map.of("message", "User registered successfully");
    }

    // 🔹 LOGIN
    public Map<String, Object> login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return Map.of("error", "User not found");
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return Map.of("error", "Invalid password");
        }

        return Map.of(
                "message", "Login successful",
                "userId", user.getId()
        );
    }
}