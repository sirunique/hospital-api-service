package com.example.task.staff.domain.mapper;

import com.example.task.staff.domain.dto.StaffDTO;
import com.example.task.staff.domain.entity.Staff;

public class StaffMapper {
    public static Staff toEntity(StaffDTO staffDTO) {
        Staff staff = new Staff(
            staffDTO.getId(),
            staffDTO.getName(),
            staffDTO.getUuid(),
            staffDTO.getRegistrationDate()
        );

        return staff;
    }
    
    public static StaffDTO toDTO(Staff staff) {
        StaffDTO staffDTO = new StaffDTO(
            staff.getId(),
            staff.getName(),
            staff.getUuid(),
            staff.getRegistrationDate()
        );
        return staffDTO;
    }
}
