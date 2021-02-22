package br.com.zup.casadocodigo.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ExistsValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Exists {
    String message() default "objeto não existe";

    String fieldName();

    Class<?> domainClass();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
