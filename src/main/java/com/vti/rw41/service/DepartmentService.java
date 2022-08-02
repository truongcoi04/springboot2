package com.vti.rw41.service;

import com.vti.rw41.Entity.Department;
import com.vti.rw41.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Integer id) {
        return departmentRepository.findById(id);
    }

    public Department addDepartment(Department department) {



        return departmentRepository.save(department);
    }

    public Optional<Department> deleteDepartment(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);


        return departmentRepository.deleteDepartment(id);
    }


    public Optional<Department> updateDepartment(Integer id, Department Department) {
        return departmentRepository.updateDepartment(id, Department);
    }

}
