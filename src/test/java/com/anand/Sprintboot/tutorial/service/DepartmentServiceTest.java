package com.anand.Sprintboot.tutorial.service;

import com.anand.Sprintboot.tutorial.entity.Department;
import com.anand.Sprintboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("6E134")
                .departmentCode("6E-69")
                .departmentaddress("Hyderabad")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("6E134")).thenReturn(department);
    }

    @Test
    @DisplayName("Tested successfuly")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "6E134";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());

    }
}