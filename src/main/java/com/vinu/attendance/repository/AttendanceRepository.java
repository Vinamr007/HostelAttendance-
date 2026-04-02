package com.vinu.attendance.repository;

import com.vinu.attendance.model.Attendance;
import com.vinu.attendance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByUser(User user);
}