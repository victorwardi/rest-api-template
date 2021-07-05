package com.vwardi.restapitemplate.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FullNameValidator implements ConstraintValidator<FullName, String> {

    @Override
    public void initialize(FullName constraintAnnotation) {

    }

    @Override
    public boolean isValid(String fullName, ConstraintValidatorContext context) {

        if(fullName == null){
            return true;
        }
        return  fullName.split(" ").length > 1;
    }
}