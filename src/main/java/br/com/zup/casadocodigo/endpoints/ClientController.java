package br.com.zup.casadocodigo.endpoints;

import br.com.zup.casadocodigo.dtos.responses.ClientCreationResponse;
import br.com.zup.casadocodigo.dtos.requests.ClientRequest;
import br.com.zup.casadocodigo.models.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<ClientCreationResponse> create(@RequestBody @Valid ClientRequest clientRequest) {

        Client client = clientRequest.toModel(entityManager);
        entityManager.persist(client);

        return ResponseEntity.ok(new ClientCreationResponse(client));
    }
}
