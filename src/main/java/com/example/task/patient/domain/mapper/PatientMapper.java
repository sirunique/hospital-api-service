package com.example.task.patient.domain.mapper;

import com.example.task.patient.domain.dto.PatientDTO;
import com.example.task.patient.domain.entity.Patient;

public class PatientMapper {
    public static Patient toEntity(PatientDTO patientDTO) {
      return new Patient(
                patientDTO.getId(),
                patientDTO.getName(),
                patientDTO.getAge(),
                patientDTO.getLastVisitDate());
    }
    
    public static PatientDTO toDTO(Patient patient) {
        return new PatientDTO(patient.getId(), patient.getName(), patient.getAge(), patient.getLastVisitDate());
    }
}
