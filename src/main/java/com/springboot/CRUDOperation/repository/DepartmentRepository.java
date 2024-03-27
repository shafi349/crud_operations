package com.springboot.CRUDOperation.repository;


import com.springboot.CRUDOperation.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDeptName(String deptName);

    public Department findByDeptNameIgnoreCase(String deptName);

}
