package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    public String street;
    public int houseNumber;
    public String postalCode;
    public String city;
    public String country;

    public Address() {}

    public Address(String street, int houseNumber, String postalCode, String city, String country) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }
}
