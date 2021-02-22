package br.com.zup.casadocodigo.books;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class BookController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid BookRequest bookRequest) {
        Book book = bookRequest.toModel(entityManager);
        entityManager.persist(book);
    }

    @GetMapping
    public ResponseEntity<List<BookIdAndTitleResponse>> listAll() {
        return ResponseEntity.ok(entityManager.createQuery("SELECT b FROM Book b", Book.class)
                .getResultStream()
                .map(BookIdAndTitleResponse::new)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailedResponse> listById(@PathVariable Long id) {
        return Optional.ofNullable(entityManager.find(Book.class, id))
                .map(book -> ResponseEntity.ok(new BookDetailedResponse(book)))
                .orElse(ResponseEntity.notFound().build());
    }
}

