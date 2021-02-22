package br.com.zup.casadocodigo.clients;

public class ClientCreationResponse {
    private Long id;

    public ClientCreationResponse(Client client) {
        this.id = client.getId();
    }

    public Long getId() {
        return id;
    }
}
