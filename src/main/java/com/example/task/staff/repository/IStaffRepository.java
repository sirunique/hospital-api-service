package com.example.task.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task.staff.domain.entity.Staff;

public interface  IStaffRepository extends JpaRepository<Staff, Long>{
    Staff findByUuid(String uuid);
}
