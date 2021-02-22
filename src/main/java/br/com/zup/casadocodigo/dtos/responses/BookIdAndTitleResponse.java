package br.com.zup.casadocodigo.dtos.responses;

import br.com.zup.casadocodigo.models.Book;

public class BookIdAndTitleResponse {

    private Long id;
    private String title;

    public BookIdAndTitleResponse(Book book) {
        id = book.getId();
        title = book.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
