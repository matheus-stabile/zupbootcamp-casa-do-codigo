package br.com.zup.casadocodigo.dtos.requests;

import br.com.zup.casadocodigo.models.Category;
import br.com.zup.casadocodigo.shared.validations.UniqueValue;

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
