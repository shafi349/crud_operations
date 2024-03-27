package com.springboot.CRUDOperation.services;

import com.springboot.CRUDOperation.entities.Department;
import com.springboot.CRUDOperation.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long deptId) throws DepartmentNotFoundException;


    public void deleteDepartmentbyId(Long deptId);

   public Department updateDepartment(Long deptId, Department department);

   public Department fetchDepartmentByName(String deptName);
}
