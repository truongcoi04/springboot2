package com.vti.rw41.Entity;


import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "products")
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "password")
    private String password;
}
