package com.example.task.staff;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.task.staff.domain.dto.CreateStaffDTO;
import com.example.task.staff.domain.dto.StaffDTO;
import com.example.task.staff.domain.dto.UpdateStaffDTO;
import com.example.task.staff.domain.entity.Staff;
import com.example.task.staff.domain.mapper.StaffMapper;
import com.example.task.staff.exception.StaffNotFoundException;
import com.example.task.staff.repository.IStaffRepository;
import com.example.task.staff.service.StaffService;

@SpringBootTest
public class StaffServiceTest {
    @Mock
    private IStaffRepository staffRepository;

    @InjectMocks
    private StaffService staffService;

    @Mock
    private StaffMapper staffMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateStaff() {
        CreateStaffDTO createStaffDTO = new CreateStaffDTO();
        createStaffDTO.setName("John Doe");

        Staff staff = new Staff();
        staff.setName("John Doe");
        staff.setUuid(UUID.randomUUID().toString());
        staff.setRegistrationDate(LocalDate.now());

        Staff savedStaff = new Staff();
        savedStaff.setId(1L);
        savedStaff.setName("John Doe");
        savedStaff.setUuid(staff.getUuid());
        savedStaff.setRegistrationDate(staff.getRegistrationDate());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setId(1L);
        staffDTO.setName("John Doe");
        staffDTO.setUuid(savedStaff.getUuid());
        staffDTO.setRegistrationDate(savedStaff.getRegistrationDate());

        when(staffRepository.save(any(Staff.class))).thenReturn(savedStaff);
        // when(StaffMapper.toDTO(savedStaff)).thenReturn(staffDTO);
        
        StaffDTO result = staffService.createStaff(createStaffDTO);

        assertNotNull(result);
        assertEquals("John Doe", result.getName());
        assertEquals(savedStaff.getUuid(), result.getUuid());
    }
    
    @Test
    public void testUpdateStaffNotFound() {
        String uuid = UUID.randomUUID().toString();

        UpdateStaffDTO updateStaffDTO = new UpdateStaffDTO();
        updateStaffDTO.setName("Jane Doe");

        when(staffRepository.findByUuid(uuid)).thenReturn(null);

        assertThrows(StaffNotFoundException.class, () -> {
            staffService.updateStaff(uuid, updateStaffDTO);
        });
    }
    
    @Test
    public void testUpdateStaff() {
        String uuid = UUID.randomUUID().toString();

        Staff existingStaff = new Staff();
        existingStaff.setId(1L);
        existingStaff.setName("John Doe");
        existingStaff.setUuid(uuid);
        existingStaff.setRegistrationDate(LocalDate.now());

        UpdateStaffDTO updateStaffDTO = new UpdateStaffDTO();
        updateStaffDTO.setName("Jane Doe");

        Staff updatedStaff = new Staff();
        updatedStaff.setId(1L);
        updatedStaff.setName("Jane Doe");
        updatedStaff.setUuid(uuid);
        updatedStaff.setRegistrationDate(existingStaff.getRegistrationDate());

        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setId(1L);
        staffDTO.setName("Jane Doe");

        when(staffRepository.findByUuid(uuid)).thenReturn(existingStaff);
        when(staffRepository.save(any(Staff.class))).thenReturn(updatedStaff);
        // when(staffMapper.toDTO(any(Staff.class))).thenReturn(staffDTO);

        StaffDTO result = staffService.updateStaff(uuid, updateStaffDTO);

        assertNotNull(result);
        assertEquals("Jane Doe", result.getName());
    }
}
