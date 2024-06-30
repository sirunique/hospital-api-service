package com.example.task.staff.domain.entity;

import java.time.LocalDate;
import java.util.UUID;

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
@Table(name = "staffs")
@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column(unique=true, nullable=false)
    private String uuid = UUID.randomUUID().toString();

    @Column(name="registration_date")
    private LocalDate registrationDate;

    // public Staff(String name) {
    //     this.name = name;
    // }
}
