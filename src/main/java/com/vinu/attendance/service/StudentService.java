package com.vinu.attendance.service;

import com.vinu.attendance.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    // Add student
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }
}