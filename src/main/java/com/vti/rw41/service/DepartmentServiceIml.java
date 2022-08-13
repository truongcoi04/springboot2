package com.vti.rw41.service;

import com.vti.rw41.Entity.Department;
import com.vti.rw41.Repository.DepartmentRepository;
import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.exeption.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceIml implements  DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll(Sort.by("id").descending()); // sort.by sắp xếp giảm dần
    }

    @Override
    public Optional<Department> getDepartmentById(Integer id) {
        Department byId = departmentRepository.findById(id)
                .orElseThrow(() -> new ApiException("department.not.exists"));
        return Optional.of(byId);
    }

    @Override
    public Department addDepartment(DepartmentRequest department) {
        Department d = new Department();
        d.setDepartmentName(department.getDepartmentName());
        return departmentRepository.save(d);
    }

    @Override
    public Optional<Department> deleteDepartment(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        department.ifPresent(d -> departmentRepository.delete(d));
        return department;
    }

    @Override
    public Optional<Department> updateDepartment(Integer id, DepartmentRequest department) {
        Optional<Department> oldDepartment = departmentRepository.findById(id);
        oldDepartment.ifPresent(d -> {
            d.setDepartmentName(department.getDepartmentName());
            departmentRepository.save(d);
        });
        return oldDepartment;
    }
}
