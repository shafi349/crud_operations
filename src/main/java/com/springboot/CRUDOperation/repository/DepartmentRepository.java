package com.springboot.CRUDOperation.repository;


import com.springboot.CRUDOperation.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDeptName(String deptName);
    Department findByDeptNameAndDeptCode(String name, String code);

    Department findByDeptNameIgnoreCase(String deptName);

}
