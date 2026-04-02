package com.vinu.attendance.service;

import com.vinu.attendance.model.Attendance;
import com.vinu.attendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repo;

    // 🔹 Save attendance
    public Attendance markAttendance(Attendance attendance) {
        return repo.save(attendance);
    }

    // 🔹 Get all attendance
    public List<Attendance> getAllAttendance() {
        return repo.findAll();
    }
}