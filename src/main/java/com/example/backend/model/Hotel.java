package com.example.backend.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Hotel extends BaseModel {
    public String name;
    public String checkIn;
    public String checkOut;
    public Address address;
    public Rating rating;
    public int lowestPrice;
    public float distanceToCentrum;

    public Hotel() {
    }

    public Hotel(String name, String checkIn, String checkOut, Address address, Rating rating, int lowestPrice, float distanceToCentrum) {
        this.name = name;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.address = address;
        this.rating = rating;
        this.lowestPrice = lowestPrice;
        this.distanceToCentrum = distanceToCentrum;
    }
}
