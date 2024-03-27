package com.springboot.CRUDOperation.services;

import com.springboot.CRUDOperation.entities.Department;
import com.springboot.CRUDOperation.error.DepartmentNotFoundException;
import com.springboot.CRUDOperation.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepertmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
//Adding department by Post method
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
//Getting all department by Post method

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }
    //Getting single by Get method

    @Override
    public Department fetchDepartmentById(Long deptId) throws DepartmentNotFoundException {
        Optional <Department> department =
                departmentRepository.findById(deptId);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
//
//    public Department fetchDepartmentById(Long deptId) {
//        return departmentRepository.findById(deptId).get();
    }
//Delete department by Delete method

    @Override
    public void deleteDepartmentbyId(Long deptId) {
        departmentRepository.deleteById(deptId);

    }
//Update department by update method

    @Override
    public Department updateDepartment(Long deptId, Department department) {
        Department depDB = departmentRepository.findById(deptId).get();

        if (Objects.nonNull(department.getDeptName())
                && !"".equalsIgnoreCase(department.getDeptName())) {
            depDB.setDeptName(department.getDeptName());
        }
        if (Objects.nonNull(department.getDeptAddress())
                && !"".equalsIgnoreCase(department.getDeptAddress())) {
            depDB.setDeptAddress(department.getDeptAddress());
        }
        if (Objects.nonNull(department.getDeptCode())
                && !"".equalsIgnoreCase(department.getDeptCode())) {
            depDB.setDeptCode(department.getDeptCode());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String deptName) {
        return departmentRepository.findByDeptNameIgnoreCase(deptName);
    }
}
