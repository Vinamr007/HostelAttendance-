package com.vinu.attendance.dto;

public class MarkAttendanceResponse {

    private String message;

    public MarkAttendanceResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}