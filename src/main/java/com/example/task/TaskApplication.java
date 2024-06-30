package com.example.task;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.task.patient.domain.entity.Patient;
import com.example.task.patient.repository.IPatientRepository;

@SpringBootApplication
@EnableTransactionManagement

public class TaskApplication {
	private final IPatientRepository patientRepository;

	public TaskApplication(IPatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}


	// @Bean
	// CommandLineRunner run(IPatientRepository patientRepository) {
	// 	return args -> {
	// 		patientRepository.saveAll(
	// 				Arrays.asList(
	// 					new Patient("John Doe", 30, LocalDate.of(2022, 1, 15)),
	// 					new Patient("Jane Smith", 25, LocalDate.of(2023, 3, 22)),
	// 					new Patient("Alice Johnson", 28, LocalDate.of(2021, 7, 10)),
	// 					new Patient("Bob Brown", 40, LocalDate.of(2023, 2, 5))
	// 			)
	// 		);
	// 	};
	// }
}
