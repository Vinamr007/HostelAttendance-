package com.vinu.attendance.controller;

import com.vinu.attendance.model.Student;
import com.vinu.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // POST API → Add student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // GET API → Get all students
    @GetMapping
    public List<Student> getStudents() {
        return service.getAllStudents();
    }
}