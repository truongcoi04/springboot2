package com.vti.rw41.Validation;

import com.vti.rw41.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameNotUniqueValidator implements ConstraintValidator<NameNotUnique, String> {

    @Autowired
    AccountRepository accountRepository;
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext){
        return accountRepository.isEmailNotExists(name);
    }



}
