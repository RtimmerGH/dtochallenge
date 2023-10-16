package com.wildcodeschool.myDtoProject.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AttributeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Attribute {


    String message() default "{Attribute}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
