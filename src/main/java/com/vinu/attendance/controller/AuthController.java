package com.vinu.attendance.controller;

import com.vinu.attendance.dto.RegisterRequest;
import com.vinu.attendance.dto.LoginRequest;
import com.vinu.attendance.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // 🔹 REGISTER API
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    // 🔹 LOGIN API
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}