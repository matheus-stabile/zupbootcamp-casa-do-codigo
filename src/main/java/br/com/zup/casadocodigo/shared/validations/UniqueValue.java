package br.com.zup.casadocodigo.shared.validations;

import br.com.zup.casadocodigo.shared.validations.validators.UniqueValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message() default "Valor duplicado";

    String fieldName();

    Class<?> domainClass();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
