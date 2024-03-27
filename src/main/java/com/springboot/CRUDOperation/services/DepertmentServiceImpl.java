package com.springboot.CRUDOperation.services;

import com.springboot.CRUDOperation.entities.Department;
import com.springboot.CRUDOperation.error.DepartmentNotFoundException;
import com.springboot.CRUDOperation.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepertmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepertmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

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
        Optional<Department> department =
                departmentRepository.findById(deptId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
//
//    public Department fetchDepartmentById(Long deptId) {
//        return departmentRepository.findById(deptId).get();
    }
//Delete department by Delete method

    @Override
    public void deleteDepartmentbyId(Long deptId) throws DepartmentNotFoundException {
        Optional<Department> optionalDepartment = departmentRepository.findById(deptId);
        if (optionalDepartment.isEmpty()) {
            throw new DepartmentNotFoundException("Department not found");
        }
        departmentRepository.deleteById(deptId);
    }
//Update department by update method

    @Override
    public Department updateDepartment(Long id, Department department) throws DepartmentNotFoundException {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isEmpty()) {
            throw new DepartmentNotFoundException("Department not found");
        }
        Department depDB = optionalDepartment.get();

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
