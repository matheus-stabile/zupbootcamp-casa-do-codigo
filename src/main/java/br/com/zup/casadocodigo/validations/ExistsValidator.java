package br.com.zup.casadocodigo.validations;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsValidator implements ConstraintValidator<Exists, Object> {

    String domainAttribute;
    Class<?> domainClass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(Exists constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        domainClass = constraintAnnotation.domainClass();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + domainClass.getName() + " WHERE " + domainAttribute + " =:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}
