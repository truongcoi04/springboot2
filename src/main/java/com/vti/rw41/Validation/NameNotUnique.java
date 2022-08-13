package com.vti.rw41.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameNotUniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameNotUnique {
    String message() default "{error.email.unique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}