package com.vti.rw41.controller;

import com.vti.rw41.Entity.Department;
import com.vti.rw41.dto.DepartmentRequest;
import com.vti.rw41.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/departments")
public class DepartmentController {

           // [R]  //  GET   / departments -> lấy tất cả departments
           // [R]  //  GET   / departments/{id} -> lấy departments theo id
           // [C]  //  POST  / departments -> tạo mới departments
           // [U]  //  PUT   / departments/{id} -> update departments theo id
           // [D]  //  DEL   / departments/{id} -> xóa departments theo id


    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }


//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Integer id) {
        log.info("getDepartmentById={}", id);
        return departmentService.getDepartmentById(id);
    }

//    @PostMapping
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Department addDepartment(@Valid @RequestBody DepartmentRequest department) {
        return departmentService.addDepartment(department);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Optional<Department> deleteDepartment(@PathVariable Integer id) {
        log.info("getDepartmentById={}", id);
       return departmentService.deleteDepartment(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Optional<Department> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentRequest department) {
        log.info("getDepartmentById={}", id);
      return departmentService.updateDepartment(id, department);
    }

}
