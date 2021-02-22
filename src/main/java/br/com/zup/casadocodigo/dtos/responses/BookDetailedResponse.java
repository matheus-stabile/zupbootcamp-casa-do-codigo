package br.com.zup.casadocodigo.dtos.responses;

import br.com.zup.casadocodigo.dtos.responses.AuthorToBookDetailedResponse;
import br.com.zup.casadocodigo.models.Book;

import java.math.BigDecimal;

public class BookDetailedResponse {

    Long id;
    String title;
    BigDecimal price;
    String synopsis;
    String summary;
    Integer pages;
    String isbn;
    AuthorToBookDetailedResponse authorDetails;

    public BookDetailedResponse(Book book) {
        id = book.getId();
        title = book.getTitle();
        price = book.getPrice();
        synopsis = book.getSynopsis();
        summary = book.getSummary();
        pages = book.getPages();
        isbn = book.getIsbn();
        authorDetails = new AuthorToBookDetailedResponse(book.getAuthor());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getSummary() {
        return summary;
    }

    public Integer getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public AuthorToBookDetailedResponse getAuthorDetails() {
        return authorDetails;
    }
}
