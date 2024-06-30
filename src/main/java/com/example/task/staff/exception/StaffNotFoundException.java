package com.example.task.staff.exception;

public class StaffNotFoundException extends RuntimeException {
    public StaffNotFoundException() {
        super("Staff not found");
    }
}
