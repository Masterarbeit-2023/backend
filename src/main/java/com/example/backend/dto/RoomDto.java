package com.example.backend.dto;

import com.example.backend.model.Facility;
import com.example.backend.model.Rate;

import java.io.Serializable;

public class RoomDto implements Serializable {

    public Long id;

    public String name;
    public Facility[] facilities;
    public Rate[] rates;
    public int numberOfPersons;
    public int roomSizeInSqm;

    public RoomDto(Long id, String name, Facility[] facilities, Rate[] rates, int numberOfPersons, int roomSizeInSqm) {
        this.id = id;
        this.name = name;
        this.facilities = facilities;
        this.rates = rates;
        this.numberOfPersons = numberOfPersons;
        this.roomSizeInSqm = roomSizeInSqm;
    }
}
