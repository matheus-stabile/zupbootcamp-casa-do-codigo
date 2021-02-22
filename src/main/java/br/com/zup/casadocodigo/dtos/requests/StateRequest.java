package br.com.zup.casadocodigo.dtos.requests;

import br.com.zup.casadocodigo.models.Country;
import br.com.zup.casadocodigo.models.State;
import br.com.zup.casadocodigo.shared.validations.Exists;
import br.com.zup.casadocodigo.shared.validations.UniqueValueIn;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@UniqueValueIn(domainClass = State.class, fields = {"name", "country_id"}, aliases = {"name", "country_id"})
public class StateRequest {

    @NotBlank
    String name;
    @Exists(domainClass = Country.class, fieldName = "id", message = "pais não está cadastrado")
    @NotNull
    private Long country_id;

    public State toModel(EntityManager entityManager) {
        Country country = entityManager.find(Country.class, country_id);

        return new State(name, country);
    }

    public String getName() {
        return name;
    }

    public Long getCountry_id() {
        return country_id;
    }
}
