package com.example.task.patient;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.task.patient.domain.mapper.PatientMapper;
import com.example.task.patient.repository.IPatientRepository;
import com.example.task.patient.service.PatientService;

@SpringBootTest
public class PatientServiceTest {
    @Mock
    private IPatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientMapper patientMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    
}
