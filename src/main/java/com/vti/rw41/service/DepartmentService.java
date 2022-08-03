package com.vti.rw41.service;

import com.vti.rw41.Entity.Department;
import com.vti.rw41.dto.DepartmentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {

    List<Department> getAllDepartment();

    Optional<Department> getDepartmentById(Integer id);

    Department addDepartment(DepartmentRequest department) ;

    Optional<Department> deleteDepartment(Integer id);


    Optional<Department> updateDepartment(Integer id, DepartmentRequest Department);

}
