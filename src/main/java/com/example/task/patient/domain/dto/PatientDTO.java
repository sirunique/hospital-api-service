package com.example.task.patient.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientDTO {
     private Long id;
    private String name;
    private int age;
    private LocalDate lastVisitDate;
}
