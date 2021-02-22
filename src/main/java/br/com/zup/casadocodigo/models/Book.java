package br.com.zup.casadocodigo.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String synopsis;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String summary;
    private BigDecimal price;
    private Integer pages;
    private String isbn;
    private LocalDate publishDate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(String title, String synopsis, String summary, BigDecimal price, Integer pages, String isbn, LocalDate publishDate, Category category, Author author) {
        this.title = title;
        this.synopsis = synopsis;
        this.summary = summary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }
}
