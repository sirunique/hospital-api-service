package com.example.task.patient.service;

import java.time.LocalDate;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.task.patient.domain.dto.PatientDTO;

public interface  IPatientService {
    void deletePatients(LocalDate starDate, LocalDate endDate);
    ByteArrayResource downloadPatientProfile(Long id);

    Page<PatientDTO> getPatientsBetweenDates(LocalDate startDate, LocalDate endDate, Pageable pageable);
    Page<PatientDTO> getPatientsUpToYears(Pageable pageable, int years);
   
}
