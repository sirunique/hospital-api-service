package com.example.task.patient.domain.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;

    @Column(name="last_visit_date")
    private LocalDate lastVisitDate;

    public Patient(String name, int age, LocalDate lastVisitDate) {
        this.name = name;
        this.age = age;
        this.lastVisitDate = lastVisitDate;
    }
    
}
