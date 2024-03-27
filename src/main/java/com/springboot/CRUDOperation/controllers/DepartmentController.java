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
@RequestMapping("/department")
public class DepartmentController {

    //    Adding data by POST method
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    // localhost:8080/department - POST
    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    //    Getting all data by Get method

    // localhost:8080/department - GET
    @GetMapping
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");

        return departmentService.fetchDepartmentList();
    }

    //    Getting single data by Get method

    // localhost:8080/department/{id} - GET
    @GetMapping("/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(deptId);
    }

    //    Get department by name
    // localhost:8080/department/name/{name} - GET
    @GetMapping("/name/{name}")
    public Department fetchsDepartmentByName(@PathVariable String name) {
        return departmentService.fetchDepartmentByName(name);

    }

    //    Delete single data by Delete method
    // localhost:8080/department/{id} - DELETE
    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        departmentService.deleteDepartmentbyId(deptId);
        return "Deleted Successfully";
    }

    //    Update single data by Put method

    // localhost:8080/department - PUT
    @PutMapping("/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long meriId, @RequestBody Department department) throws Exception {
        return departmentService.updateDepartment(meriId, department);
    }


}
