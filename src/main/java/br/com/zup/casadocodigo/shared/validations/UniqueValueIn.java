package br.com.zup.casadocodigo.shared.validations;

import br.com.zup.casadocodigo.shared.validations.validators.UniqueValueInValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueInValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValueIn {
    String message() default "Valor duplicado";

    String[] fields();

    String[] aliases();

    Class<?> domainClass();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
