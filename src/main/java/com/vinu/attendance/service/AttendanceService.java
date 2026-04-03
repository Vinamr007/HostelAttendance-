package com.vinu.attendance.service;

import com.vinu.attendance.model.Attendance;
import com.vinu.attendance.model.User;
import com.vinu.attendance.repository.AttendanceRepository;
import com.vinu.attendance.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ MARK ATTENDANCE
    public Map<String, Object> markAttendanceByUserId(Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return Map.of("error", "User not found");
        }

        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendance.setDate(LocalDate.now().toString());
        attendance.setTime(LocalTime.now().toString());
        attendance.setStatus("PRESENT");

        attendanceRepository.save(attendance);

        return Map.of("message", "Attendance Marked Successfully");
    }

    // ✅ GET ALL ATTENDANCE
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // ✅ GET ATTENDANCE BY USER
    public Map<String, Object> getAttendanceByUser(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return Map.of("error", "User not found");
        }

        List<Attendance> list = attendanceRepository.findByUser(user);

        return Map.of(
                "userId", id,
                "records", list
        );
    }

    // ✅ ATTENDANCE PERCENTAGE
    public Map<String, Object> getAttendancePercentage(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return Map.of("error", "User not found");
        }

        List<Attendance> list = attendanceRepository.findByUser(user);

        if (list.isEmpty()) {
            return Map.of(
                    "userId", id,
                    "percentage", 0,
                    "message", "No attendance records"
            );
        }

        int total = list.size();
        int present = 0;

        for (Attendance a : list) {
            if ("PRESENT".equalsIgnoreCase(a.getStatus())) {
                present++;
            }
        }

        double percentage = (present * 100.0) / total;

        return Map.of(
                "userId", id,
                "totalDays", total,
                "presentDays", present,
                "percentage", percentage
        );
    }
}