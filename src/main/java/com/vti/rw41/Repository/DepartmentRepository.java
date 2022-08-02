package com.vti.rw41.Repository;

import com.vti.rw41.Entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {

}


