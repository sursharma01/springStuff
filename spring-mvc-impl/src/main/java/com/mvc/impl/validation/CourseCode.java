package com.mvc.impl.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    // define default course code
    public String value() default "FUN";

    // define default error message
    public String message() default "must start with FUN";

    // define groups
    public Class<?>[] groups() default {};
    //define default payload
    public Class<? extends Payload>[] payload() default {};

}
