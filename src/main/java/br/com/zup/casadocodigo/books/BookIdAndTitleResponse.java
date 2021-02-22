package br.com.zup.casadocodigo.books;

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
