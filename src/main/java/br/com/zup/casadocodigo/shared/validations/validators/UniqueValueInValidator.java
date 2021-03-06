package br.com.zup.casadocodigo.shared.validations.validators;

import br.com.zup.casadocodigo.shared.validations.UniqueValueIn;
import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UniqueValueInValidator implements ConstraintValidator<UniqueValueIn, Object> {

    protected List<String> fields;
    protected List<String> aliases;
    protected Class<?> domainClass;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void initialize(UniqueValueIn constraintAnnotation) {
        fields = Arrays.asList(constraintAnnotation.fields());
        aliases = Arrays.asList(constraintAnnotation.aliases());
        domainClass = constraintAnnotation.domainClass();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        String stringQuery = queryBuilder();

        System.out.println("stringQuery = " + stringQuery);

        Query query = entityManager.createQuery(stringQuery);

        for (int i = 0; i < aliases.size(); i++) {
            query.setParameter(fields.get(i), new BeanWrapperImpl(value)
                    .getPropertyValue(fields.get(i)));
        }

        return query.getResultList().isEmpty();
    }

    protected String queryBuilder() {

        String filter = IntStream.range(0, aliases.size())
                .mapToObj(i -> " and " + aliases.get(i) + " = :" + fields.get(i))
                .collect(Collectors.joining())
                .replaceFirst("and", "where");

        return "select 0 from " + domainClass.getName() + filter;
    }
}
