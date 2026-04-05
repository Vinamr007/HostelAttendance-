package com.vinu.attendance.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String name;
    private String email;

    // 🔹 GET ID
    public Long getId() {
        return id;
    }

    // 🔹 SET ID
    public void setId(Long id) {
        this.id = id;
    }

    // 🔹 GET USERNAME
    public String getUsername() {
        return username;
    }

    // 🔹 SET USERNAME
    public void setUsername(String username) {
        this.username = username;
    }

    // 🔹 GET PASSWORD
    public String getPassword() {
        return password;
    }

    // 🔹 SET PASSWORD
    public void setPassword(String password) {
        this.password = password;
    }

    // 🔹 GET NAME
    public String getName() {
        return name;
    }

    // 🔹 SET NAME
    public void setName(String name) {
        this.name = name;
    }

    // 🔹 GET EMAIL
    public String getEmail() {
        return email;
    }

    // 🔹 SET EMAIL
    public void setEmail(String email) {
        this.email = email;
    }
}