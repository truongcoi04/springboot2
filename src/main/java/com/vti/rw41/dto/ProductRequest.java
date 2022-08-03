package com.vti.rw41.dto;

import com.vti.rw41.Validation.Password;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductRequest {
    @NotNull
    @Length(min = 6,max = 12)
    private String name;


    @NotNull
    @Positive
    private Double price;

    @NotNull
    @Password
    private String password;
}
