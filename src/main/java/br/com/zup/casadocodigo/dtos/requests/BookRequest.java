package br.com.zup.casadocodigo.dtos.requests;

import br.com.zup.casadocodigo.models.Author;
import br.com.zup.casadocodigo.models.Category;
import br.com.zup.casadocodigo.models.Book;
import br.com.zup.casadocodigo.shared.validations.Exists;
import br.com.zup.casadocodigo.shared.validations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookRequest {

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;
    @NotBlank
    @Size(max = 500)
    private String synopsis;
    private String summary;
    @NotNull
    @DecimalMin("20")
    private BigDecimal price;
    @NotNull
    @Min(100)
    private Integer pages;
    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publishDate;
    @Exists(domainClass = Category.class, fieldName = "id", message = "categoria não existe")
    private Long category_id;
    @Exists(domainClass = Author.class, fieldName = "id", message = "autor não existe")
    private Long author_id;

    public Book toModel(EntityManager entityManager) {
        Category category = entityManager.find(Category.class, category_id);
        Author author = entityManager.find(Author.class, author_id);

        return new Book(title, synopsis, summary, price, pages, isbn, publishDate, category, author);
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public Long getAuthor_id() {
        return author_id;
    }
}
