package br.com.fiap.Shift.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LicenseValidator implements ConstraintValidator<ValidLicense, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        // Basic check: must be exactly 11 digits
        return value.matches("\\d{11}");
    }
}
