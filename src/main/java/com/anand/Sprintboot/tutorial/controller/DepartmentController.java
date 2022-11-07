package com.anand.Sprintboot.tutorial.controller;

import com.anand.Sprintboot.tutorial.Error.DepartmentNotFoundException;
import com.anand.Sprintboot.tutorial.entity.Department;
import com.anand.Sprintboot.tutorial.service.DepartmentService;
import com.anand.Sprintboot.tutorial.service.DepartmentServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/department")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/department/{Id}")
    public Department fetchDepartmentById(@PathVariable("Id") Long departmentId) throws DepartmentNotFoundException {
           return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/department/{Id}")
    public String deleteDepartmentById(@PathVariable("Id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    
    }
    @PutMapping("/department/{Id}")
    public Department updateDepartmentById(@PathVariable("Id") Long departmentId,@RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/department/Name/{Name}")
    public Department fetchDepartmentByName(@PathVariable("Name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
