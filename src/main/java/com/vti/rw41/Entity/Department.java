package com.vti.rw41.Entity;

import lombok.Data;
import javax.persistence.*;
@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentId")
    private Integer id;
    private String departmentName;


}