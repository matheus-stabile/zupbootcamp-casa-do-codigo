package br.com.zup.casadocodigo.clients;

import br.com.zup.casadocodigo.countries.Country;
import br.com.zup.casadocodigo.states.State;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String document;
    private String address;
    private String addressComplement;
    private String city;
    @ManyToOne
    private Country country;
    @ManyToOne
    private State state;
    private String phone;
    private String zipCode;

    public Client(String email, String firstName, String lastName, String document, String address, String addressComplement, String city, Country country, State state, String phone, String zipCode) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.addressComplement = addressComplement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
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

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }
}
