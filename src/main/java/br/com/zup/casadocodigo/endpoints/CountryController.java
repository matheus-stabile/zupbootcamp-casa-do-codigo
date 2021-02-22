package br.com.zup.casadocodigo.endpoints;

import br.com.zup.casadocodigo.dtos.requests.CountryRequest;
import br.com.zup.casadocodigo.models.Country;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class CountryController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid CountryRequest countryRequest) {
        Country country = countryRequest.toModel();
        entityManager.persist(country);
    }
}
