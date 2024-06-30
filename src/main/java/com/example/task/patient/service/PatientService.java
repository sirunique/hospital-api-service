package com.example.task.patient.service;

import java.time.LocalDate;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.task.patient.domain.dto.PatientDTO;
import com.example.task.patient.domain.mapper.PatientMapper;
import com.example.task.patient.exception.PatientNotFoundException;
import com.example.task.patient.repository.IPatientRepository;

@Service
public class PatientService implements IPatientService {
    private IPatientRepository patientRepository;

    public PatientService(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientDTO getPatientById(Long id) {
        return patientRepository.findById(id).map(PatientMapper::toDTO).orElse(null);
    }

    public ByteArrayResource downloadPatientProfile(Long id) {
        PatientDTO patient = this.getPatientById(id);
        if (patient == null) {
            throw new PatientNotFoundException();
        }

        String csvContent = "id, name, age, lastVisitDate\n" + 
            patient.getId() + "," + patient.getName() + "," + patient.getAge() + "," + patient.getLastVisitDate() + "\n";

        ByteArrayResource resource = new ByteArrayResource(csvContent.getBytes());
        return resource;
    }

    public Page<PatientDTO> getPatientsBetweenDates(LocalDate startDate, LocalDate endDate, Pageable pageable) {
        return patientRepository.findByLastVisitDateBetween(startDate, endDate, pageable).map(PatientMapper::toDTO);
    }

    public Page<PatientDTO> getPatientsUpToYears(Pageable pageable, int years) {
        return patientRepository.findByLastVisitDateAfter(LocalDate.now().minusYears(years), pageable).map(PatientMapper::toDTO);
    }

    @Transactional
    public void deletePatients(LocalDate starDate, LocalDate endDate) {
        patientRepository.deleteByLastVisitDateBetween(starDate, endDate);
    }
}
