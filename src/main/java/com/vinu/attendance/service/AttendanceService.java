package com.vinu.attendance.service;

import com.vinu.attendance.model.Attendance;
import com.vinu.attendance.model.User;
import com.vinu.attendance.repository.AttendanceRepository;
import com.vinu.attendance.repository.UserRepository;

import com.vinu.attendance.dto.AttendanceResponse;
import com.vinu.attendance.dto.AttendanceListResponse;
import com.vinu.attendance.dto.MarkAttendanceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private UserRepository userRepository;

    // 🔹 MARK ATTENDANCE
    public MarkAttendanceResponse markAttendanceByUserId(Long userId) {

        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            return new MarkAttendanceResponse("User not found");
        }

        Attendance attendance = new Attendance();
        attendance.setUser(user);
        attendance.setDate(LocalDate.now().toString());
        attendance.setTime(LocalTime.now().toString());
        attendance.setStatus("PRESENT");

        attendanceRepository.save(attendance);

        return new MarkAttendanceResponse("Attendance Marked Successfully");
    }

    // 🔹 GET ALL ATTENDANCE
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // 🔹 GET ATTENDANCE BY USER
    public AttendanceListResponse getAttendanceByUser(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return new AttendanceListResponse(id, List.of());
        }

        List<Attendance> list = attendanceRepository.findByUser(user);

        return new AttendanceListResponse(id, list);
    }

    // 🔹 ATTENDANCE PERCENTAGE (DTO)
    public AttendanceResponse getAttendancePercentage(Long id) {

        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return new AttendanceResponse(id, 0, 0, 0, "User not found");
        }

        List<Attendance> list = attendanceRepository.findByUser(user);

        if (list.isEmpty()) {
            return new AttendanceResponse(id, 0, 0, 0, "No attendance records");
        }

        int total = list.size();
        int present = 0;

        for (Attendance a : list) {
            if ("PRESENT".equalsIgnoreCase(a.getStatus())) {
                present++;
            }
        }

        double percentage = (present * 100.0) / total;

        return new AttendanceResponse(id, total, present, percentage, "Success");
    }
}