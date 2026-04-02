package com.vinu.attendance.controller;

import com.vinu.attendance.model.User;
import com.vinu.attendance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User loggedInUser = service.login(user.getUsername(), user.getPassword());

        if (loggedInUser != null) {
            return "Login Successful";
        } else {
            return "Invalid Credentials";
        }
    }
}