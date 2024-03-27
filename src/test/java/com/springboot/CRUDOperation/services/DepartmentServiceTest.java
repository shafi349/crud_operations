package com.springboot.CRUDOperation.services;

import com.springboot.CRUDOperation.entities.Department;
import com.springboot.CRUDOperation.repository.DepartmentRepository;
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
       Department department = Department.builder().
               deptName("IT").
               deptAddress("Lhr").
               deptCode("IT-06").
               deptId(1L).build();

       Mockito.when(departmentRepository.findByDeptNameIgnoreCase("IT")).
               thenReturn(department);
   }
    @Test
    @DisplayName("Get data based on valid department Name ")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
    String deptName="IT";
        Department found = departmentService.fetchDepartmentByName(deptName);
    assertEquals(deptName, found.getDeptName());

   }
}