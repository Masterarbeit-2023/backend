package com.example.backend.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Address extends BaseModel {
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
