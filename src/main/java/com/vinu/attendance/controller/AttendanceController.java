package com.vinu.attendance.controller;

import com.vinu.attendance.model.Attendance;
import com.vinu.attendance.service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // ✅ MARK ATTENDANCE
    @PostMapping("/mark")
    public Map<String, Object> markAttendance(@RequestParam Long userId) {
        return attendanceService.markAttendanceByUserId(userId);
    }

    // ✅ GET ALL ATTENDANCE
    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    // ✅ GET ATTENDANCE BY USER
    @GetMapping("/user/{id}")
    public Map<String, Object> getAttendanceByUser(@PathVariable Long id) {
        return attendanceService.getAttendanceByUser(id);
    }

    // ✅ ATTENDANCE PERCENTAGE
    @GetMapping("/percentage/{id}")
    public Map<String, Object> getAttendancePercentage(@PathVariable Long id) {
        return attendanceService.getAttendancePercentage(id);
    }
}