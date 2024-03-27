package com.springboot.CRUDOperation.controllers;

import com.springboot.CRUDOperation.entities.Department;
import com.springboot.CRUDOperation.error.DepartmentNotFoundException;
import com.springboot.CRUDOperation.services.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    //    Adding data by POST method
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    //    Getting all data by Get method

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");

        return departmentService.fetchDepartmentList();
    }

    //    Getting single data by Get method

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(deptId);
    }

    //    Get department by name
    @GetMapping("/departments/name/{name}")
    public Department fetchsDepartmentByName(@PathVariable("name") String deptName) {
        return departmentService.fetchDepartmentByName(deptName);

    }

    //    Delete single data by Delete method

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long deptId) {
        departmentService.deleteDepartmentbyId(deptId);
        return "Deleted Successfully";
    }

    //    Update single data by Put method

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long deptId, @RequestBody Department department) {
        return departmentService.updateDepartment(deptId, department);
    }


}
