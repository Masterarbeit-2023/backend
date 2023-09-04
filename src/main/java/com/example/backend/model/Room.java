package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room extends BaseModel {

    public String name;
    public int numberOfPersons;
    public int roomSizeInSqm;

    public boolean petsAllowed;

    public Room() {
    }

    public Room(String name, Facility[] facilities, Rate[] rates, int numberOfPersons, int roomSizeInSqm, boolean petsAllowed) {
        this.name = name;
        this.numberOfPersons = numberOfPersons;
        this.roomSizeInSqm = roomSizeInSqm;
    }
}
