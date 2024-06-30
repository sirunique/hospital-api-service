package com.example.task.staff.domain.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDTO {
    private Long id;
    private String name;
    private String uuid;
    private LocalDate registrationDate;

    /**
     * @param id
     * @param name
     * @param uuid
     * @param registrationDate
     */
    // public StaffDTO(Long id, String name, String uuid, LocalDate registrationDate) {
    //     this.id = id;
    //     this.name = name;
    //     this.uuid = uuid;
    //     this.registrationDate = registrationDate;
    // }    
}