package com.anand.Sprintboot.tutorial.controller;

import com.anand.Sprintboot.tutorial.Error.DepartmentNotFoundException;
import com.anand.Sprintboot.tutorial.entity.Department;
import com.anand.Sprintboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("6E1345")
                .departmentaddress("Hyderabad")
                .departmentCode("6E-69")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
       Department inputDepartment = Department.builder()
                .departmentName("6E1345")
                .departmentaddress("Hyderabad")
                .departmentCode("6E-69")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/department").contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "\t\"departmentName\":\"6E1345\",\n" +
                "\t\"departmentaddress\":\"Hyderabad\",\n" +
                "\t\"departmentCode\":\"6E-69\"\n" +
                "} "))
                .andExpect(status().isOk());
    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1l)).thenReturn(department);

        mockMvc.perform(get("")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
    }
}