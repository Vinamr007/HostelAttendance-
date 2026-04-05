package com.vinu.attendance.dto;

public class AttendanceResponse {

    private Long userId;
    private int totalDays;
    private int presentDays;
    private double percentage;
    private String message;

    // 🔹 Constructor
    public AttendanceResponse(Long userId, int totalDays, int presentDays, double percentage, String message) {
        this.userId = userId;
        this.totalDays = totalDays;
        this.presentDays = presentDays;
        this.percentage = percentage;
        this.message = message;
    }

    // 🔹 Getters
    public Long getUserId() {
        return userId;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public int getPresentDays() {
        return presentDays;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getMessage() {
        return message;
    }
}