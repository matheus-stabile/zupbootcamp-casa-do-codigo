package br.com.zup.casadocodigo.authors;

public class AuthorToBookDetailedResponse {

    String name;
    String description;

    public AuthorToBookDetailedResponse(Author author) {
        name = author.getName();
        description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
