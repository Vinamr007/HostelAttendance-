package com.vinu.attendance.controller;

import com.vinu.attendance.model.Attendance;
import com.vinu.attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping
    public Attendance mark(@RequestBody Attendance attendance) {
        return service.markAttendance(attendance);
    }

    @GetMapping
    public List<Attendance> getAll() {
        return service.getAllAttendance();
    }
}