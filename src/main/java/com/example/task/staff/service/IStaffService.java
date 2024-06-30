package com.example.task.staff.service;

import com.example.task.staff.domain.dto.CreateStaffDTO;
import com.example.task.staff.domain.dto.StaffDTO;
import com.example.task.staff.domain.dto.UpdateStaffDTO;

public interface IStaffService {
    StaffDTO createStaff(CreateStaffDTO createStaffDTO);
    StaffDTO updateStaff(String uuid, UpdateStaffDTO updateStaffDTO);
}
