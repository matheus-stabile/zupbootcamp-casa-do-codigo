package br.com.zup.casadocodigo.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckIfStateIsRequiredValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckIfStateIsRequired {

    String message() default "é preciso informar um estado válido para este país";

    Class<?> stateClass();

    String country();

    String state_id_alias();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
