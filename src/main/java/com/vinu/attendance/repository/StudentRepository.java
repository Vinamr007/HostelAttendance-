package com.vinu.attendance.repository;

import com.vinu.attendance.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}