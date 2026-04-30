package br.com.fiap.Shift.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LicenseValidator.class)
@Documented
public @interface ValidLicense {
    String message() default "Invalid driver's license format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
