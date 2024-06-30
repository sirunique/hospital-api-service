package com.example.task.patient.controller;

import java.awt.PageAttributes;
import java.io.IOException;
import java.time.LocalDate;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.patient.domain.dto.PatientDTO;
import com.example.task.patient.service.IPatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    private final IPatientService patientService;

    public PatientController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<ByteArrayResource> downloadPatientProfile(@PathVariable Long id) throws IOException {
        ByteArrayResource csvData = patientService.downloadPatientProfile(id);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=patient_" + id + ".csv")
        .contentType(MediaType.TEXT_PLAIN)
        .body(csvData);
    }

    @GetMapping
    public ResponseEntity<Page<PatientDTO>> getPatients(
        Pageable pageable,
        @RequestParam(required = false) LocalDate startDate,
        @RequestParam(required = false) LocalDate endDate,
        @RequestParam(required = false) int years
    ) {
        Page<PatientDTO> patients;
        if (startDate != null && endDate != null) {
            patients = patientService.getPatientsBetweenDates(startDate, endDate, pageable);
        } else {
            patients = patientService.getPatientsUpToYears(pageable, years);
        }
        return ResponseEntity.ok(patients);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePatients(
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        patientService.deletePatients(startDate, endDate);
        return new ResponseEntity<>("Patients deleted", HttpStatus.OK);
    }
}
