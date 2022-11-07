package com.anand.Sprintboot.tutorial.repository;

import com.anand.Sprintboot.tutorial.entity.Department;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Mechanical Engineering")
                .departmentaddress("Banglore")
                .departmentCode("6E-69")
                .build();

        entityManager.persist(department);
    }

    @Test
    @DisplayName("Tested OK")
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();

        assertEquals(department.getDepartmentName(),"Mechanical Engineering");
    }
}