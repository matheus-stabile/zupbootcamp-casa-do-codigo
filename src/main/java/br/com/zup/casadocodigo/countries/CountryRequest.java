package br.com.zup.casadocodigo.countries;

import br.com.zup.casadocodigo.validations.UniqueValue;

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
