package br.com.zup.casadocodigo.dtos.requests;

import br.com.zup.casadocodigo.models.Country;
import br.com.zup.casadocodigo.shared.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CountryRequest {

    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    private String name;

    public Country toModel() {
        return new Country(name);
    }

    public String getName() {
        return name;
    }
}
