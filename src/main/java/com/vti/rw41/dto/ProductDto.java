package com.vti.rw41.dto;

import lombok.Data;


import java.time.LocalDateTime;

@Data
public class ProductDto {
private Integer id;
private String name;
private double price;
private LocalDateTime createdDate;
private String category;
}
