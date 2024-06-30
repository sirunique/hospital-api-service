package com.example.task.patient.exception;

public class PatientNotFoundException extends  RuntimeException {
    public PatientNotFoundException() {
        super("Patient not found");
    }
}
