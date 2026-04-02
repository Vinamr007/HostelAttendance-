package com.vinu.attendance.controller;

import com.vinu.attendance.model.Attendance;
import com.vinu.attendance.model.User;
import com.vinu.attendance.repository.AttendanceRepository;
import com.vinu.attendance.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ MARK ATTENDANCE
    @PostMapping("/mark")
    public String markAttendance(@RequestParam Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return "User not found";
        }

        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendance.setDate(LocalDate.now().toString());
        attendance.setTime(LocalTime.now().toString());
        attendance.setStatus("PRESENT");

        attendanceRepository.save(attendance);

        return "Attendance Marked Successfully";
    }

    // ✅ GET ALL ATTENDANCE
    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // ✅ GET ATTENDANCE BY USER
    @GetMapping("/user/{id}")
    public List<Attendance> getAttendanceByUser(@PathVariable Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }

        return attendanceRepository.findByUser(user);
    }

    // ✅ ATTENDANCE PERCENTAGE
    @GetMapping("/percentage/{id}")
    public String getAttendancePercentage(@PathVariable Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return "User not found";
        }

        List<Attendance> list = attendanceRepository.findByUser(user);

        int total = list.size();
        int present = 0;

        for (Attendance a : list) {
            if ("PRESENT".equals(a.getStatus())) {
                present++;
            }
        }

        if (total == 0) {
            return "No attendance data";
        }

        double percentage = (present * 100.0) / total;

        return "Attendance % = " + percentage;
    }
}