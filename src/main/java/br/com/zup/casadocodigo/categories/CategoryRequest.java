package br.com.zup.casadocodigo.categories;

import br.com.zup.casadocodigo.validations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    public Category toModel() {
        return new Category(name);
    }

    public String getName() {
        return name;
    }
}
