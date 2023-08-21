package com.example.backend.model;

public class Hotel extends BaseModel {
    public String name;
    public String checkIn;
    public String checkOut;
    public Address address;
    public Rating rating;
    public Rating[] userRatings;
    public int lowestPrice;
    public float distanceToCentrum;
    public String[] services;
    public String[] facilities;

    public Hotel() {
    }

    public Hotel(String name, String checkIn, String checkOut, Address address, Rating rating, Rating[] userRatings, int lowestPrice, float distanceToCentrum, String[] services, String[] facilities) {
        this.name = name;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.address = address;
        this.rating = rating;
        this.userRatings = userRatings;
        this.lowestPrice = lowestPrice;
        this.distanceToCentrum = distanceToCentrum;
        this.services = services;
        this.facilities = facilities;
    }
}
