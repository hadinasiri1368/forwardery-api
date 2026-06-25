package com.forwardery.validator;

import com.forwardery.util.AppUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotEmptyValidator implements ConstraintValidator<NotEmpty, Object> {
    private NotEmpty annotation;

    @Override
    public void initialize(NotEmpty annotation) {
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (AppUtils.isNull(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(annotation.message() + "&" + annotation.fieldName()).addConstraintViolation();
            return false;
        }
        return true;
    }

}

