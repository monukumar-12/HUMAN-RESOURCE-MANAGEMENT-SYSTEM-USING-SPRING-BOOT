package com.module2.layersMVC.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmployeeRollValidator.class})
public @interface EmployeeRoleValidation {

    String message() default "IRole odf employee will user or admit ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
