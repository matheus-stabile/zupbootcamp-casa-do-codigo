package br.com.zup.casadocodigo.categories;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category category = categoryRequest.toModel();
        entityManager.persist(category);
    }
}
