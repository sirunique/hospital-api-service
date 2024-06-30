package com.example.task.staff.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task.staff.domain.dto.CreateStaffDTO;
import com.example.task.staff.domain.dto.StaffDTO;
import com.example.task.staff.domain.dto.UpdateStaffDTO;
import com.example.task.staff.service.IStaffService;

@RestController
@RequestMapping("/api/staffs")
public class StaffController {
    private IStaffService staffService;

    public StaffController(IStaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping
    public ResponseEntity<StaffDTO> addStaff(@RequestBody CreateStaffDTO createStaffDTO) {
        return new ResponseEntity<>(staffService.createStaff(createStaffDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<StaffDTO> updateStaff(@PathVariable String uuid,
         @RequestBody UpdateStaffDTO updateStaffDTO) {
        return new ResponseEntity<>(staffService.updateStaff(uuid, updateStaffDTO), HttpStatus.OK);
    }
     
}
