package com.vinu.attendance.dto;

import com.vinu.attendance.model.Attendance;
import java.util.List;

public class AttendanceListResponse {

    private Long userId;
    private List<Attendance> records;

    public AttendanceListResponse(Long userId, List<Attendance> records) {
        this.userId = userId;
        this.records = records;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Attendance> getRecords() {
        return records;
    }
}