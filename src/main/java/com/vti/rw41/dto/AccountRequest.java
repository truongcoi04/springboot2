package com.vti.rw41.dto;

import com.vti.rw41.Validation.EmailNotUnique;
import com.vti.rw41.Validation.Password;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
@Data
public class AccountRequest {

    @NotNull
    @Email
    @EmailNotUnique
    private String email;

    @NotNull
    @Password
    private String password;

    @NotNull
    @Length(min = 6,max = 12)
    private String fullName;

    @Past
    private LocalDate birthday;
}
