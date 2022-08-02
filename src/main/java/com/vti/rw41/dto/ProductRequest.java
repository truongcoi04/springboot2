package com.vti.rw41.dto;

import com.vti.rw41.Validation.Password;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class ProductRequest {
    @NotNull
    @Email
    private String email;

    @NotNull
    @Length(min = 5,max = 12)
    private String name;

    @NotNull
    @Positive
    private Double price;

    @Password
    private String password;
}
