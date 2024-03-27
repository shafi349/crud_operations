package com.springboot.CRUDOperation.repository;

import com.springboot.CRUDOperation.entities.Department;
import org.junit.jupiter.api.BeforeEach;
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
        Department department=
                Department.builder().
                deptName("Mech Engr").
                deptCode("ME-01").
                deptAddress("Lahore").build();

        entityManager.persist(department);

    }
    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDeptName(),"Mech Engr");
    }
}