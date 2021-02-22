package br.com.zup.casadocodigo.authors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AuthorsController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid AuthorRequest authorRequest) {
        Author author = authorRequest.toModel();
        entityManager.persist(author);
    }
}
