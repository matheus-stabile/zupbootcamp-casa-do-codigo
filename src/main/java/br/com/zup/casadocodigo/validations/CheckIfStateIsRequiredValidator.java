package br.com.zup.casadocodigo.validations;

import org.springframework.beans.BeanWrapperImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckIfStateIsRequiredValidator implements ConstraintValidator<CheckIfStateIsRequired, Object> {

    protected Class<?> domainClass;
    protected Class<?> stateClass;
    protected String country;
    protected String state_id_alias;

    @PersistenceContext
    EntityManager entityManager;

    public void initialize(CheckIfStateIsRequired constraint) {
        stateClass = constraint.stateClass();
        country = constraint.country();
        state_id_alias = constraint.state_id_alias();
    }

    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        BeanWrapperImpl wrapper = new BeanWrapperImpl(obj);
        Object country_id = wrapper.getPropertyValue("country_id");
        Object state_id = wrapper.getPropertyValue("state_id");

        // Check if there are any State with the informed country_id.
        Query query = entityManager.createQuery("select 1 from " + stateClass.getName() + " where " + country + " = :country_id");
        query.setParameter("country_id", country_id);
        List<?> list = query.getResultList();

        // If can't find states in current country the object is valid.
        if (list.isEmpty()) {
            return true;
        }

        // If found states in current country and state exists the object is valid.
        if (isValid(state_id)) {
            return true;
        }

        // If found states in current country and state not exists the object is invalid.
        return false;

    }

    public boolean isValid(Object obj) {
        Query query = entityManager.createQuery("select 1 from " + stateClass.getName() + " where " + state_id_alias + " = :state_id");
        query.setParameter("state_id", obj);
        List<?> list = query.getResultList();

        return !list.isEmpty();
    }
}
