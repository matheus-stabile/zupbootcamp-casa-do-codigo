package br.com.zup.casadocodigo.dtos.requests;

import br.com.zup.casadocodigo.models.Author;
import br.com.zup.casadocodigo.shared.validations.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String description;

    public Author toModel() {
        return new Author(name, email, description);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }
}
