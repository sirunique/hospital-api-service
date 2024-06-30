package com.example.task.staff.service;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.task.staff.domain.dto.CreateStaffDTO;
import com.example.task.staff.domain.dto.StaffDTO;
import com.example.task.staff.domain.dto.UpdateStaffDTO;
import com.example.task.staff.domain.entity.Staff;
import com.example.task.staff.domain.mapper.StaffMapper;
import com.example.task.staff.exception.StaffNotFoundException;
import com.example.task.staff.repository.IStaffRepository;


@Service
public class StaffService implements IStaffService {
    
    private IStaffRepository staffRepository;

    public StaffService(IStaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public StaffDTO createStaff(CreateStaffDTO createStaffDTO) {
        Staff staff = new Staff();
        staff.setName(createStaffDTO.getName());
        staff.setUuid(UUID.randomUUID().toString());
        staff.setRegistrationDate(LocalDate.now());
        Staff savedStaff = staffRepository.save(staff);
        return StaffMapper.toDTO(savedStaff);
    }

    @Override
    public StaffDTO updateStaff(String uuid, UpdateStaffDTO updateStaffDTO) {
        Staff staff = staffRepository.findByUuid(uuid);
        if (staff == null) {
            throw new StaffNotFoundException();
        }

        staff.setName(updateStaffDTO.getName());
        Staff updatedStaff = staffRepository.save(staff);
        return StaffMapper.toDTO(updatedStaff);
    }
    
    public boolean validateStaffUuid(String uuid) {
        return staffRepository.findByUuid(uuid) != null;
    }
}
