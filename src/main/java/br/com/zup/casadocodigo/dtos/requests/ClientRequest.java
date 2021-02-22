package br.com.zup.casadocodigo.dtos.requests;

import br.com.zup.casadocodigo.models.Country;
import br.com.zup.casadocodigo.models.Client;
import br.com.zup.casadocodigo.models.State;
import br.com.zup.casadocodigo.shared.validations.CheckIfStateIsRequired;
import br.com.zup.casadocodigo.shared.validations.Exists;
import br.com.zup.casadocodigo.shared.validations.IsCpfOrCnpj;
import br.com.zup.casadocodigo.shared.validations.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@CheckIfStateIsRequired(stateClass = State.class, country = "country_id", state_id_alias = "id")
public class ClientRequest {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Client.class, fieldName = "email")
    private String email;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @IsCpfOrCnpj
    @UniqueValue(domainClass = Client.class, fieldName = "document")
    private String document;
    @NotBlank
    private String address;
    @NotBlank
    private String addressComplement;
    @NotBlank
    private String city;
    @NotNull
    @Exists(domainClass = Country.class, fieldName = "id", message = "pais não está cadastrado")
    private Long country_id;
    private Long state_id;
    @NotBlank
    private String phone;
    @NotBlank
    private String zipCode;

    public Client toModel(EntityManager entityManager) {
        Country country = entityManager.find(Country.class, country_id);

        if (state_id != null) {
            State state = entityManager.find(State.class, state_id);
            return new Client(email, firstName, lastName, document, address, addressComplement, city, country, state, phone, zipCode);
        }

        return new Client(email, firstName, lastName, document, address, addressComplement, city, country, null, phone, zipCode);
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public String getCity() {
        return city;
    }

    public Long getCountry_id() {
        return country_id;
    }

    public Long getState_id() {
        return state_id;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }
}
