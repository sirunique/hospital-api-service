package com.example.task.patient.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.task.patient.domain.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
    
    @Transactional
    @Modifying
    @Query("DELETE FROM Patient p WHERE p.lastVisitDate BETWEEN :startDate AND :endDate")
    void deleteByLastVisitDateBetween(LocalDate startDate, LocalDate endDate);


    @Query(value = "SELECT * FROM patients WHERE last_visit_date >= :startDate AND last_visit_date <= :endDate",
            nativeQuery = true)
    Page<Patient> findByLastVisitDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    @Query(value = "SELECT * FROM patients WHERE last_visit_date >= :startDate",
            nativeQuery = true)
    Page<Patient> findByLastVisitDateAfter(LocalDate startDate, Pageable pageable);
}
