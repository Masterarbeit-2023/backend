package com.example.backend.model;

public class Room {
    public String name;
    public String[] facilities;
    public Rate[] rates;

    public Room(){}
    public Room(String name, String[] facilities, Rate[] rates) {
        this.name = name;
        this.facilities = facilities;
        this.rates = rates;
    }
}
