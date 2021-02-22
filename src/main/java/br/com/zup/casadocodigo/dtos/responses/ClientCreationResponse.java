package br.com.zup.casadocodigo.dtos.responses;

import br.com.zup.casadocodigo.models.Client;

public class ClientCreationResponse {
    private Long id;

    public ClientCreationResponse(Client client) {
        this.id = client.getId();
    }

    public Long getId() {
        return id;
    }
}
