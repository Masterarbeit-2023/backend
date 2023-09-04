package com.example.backend.model;

import jakarta.persistence.*;

@Entity
public class Facility extends BaseModel {

    public String name;

    public Facility(String name) {
        this.name = name;
    }

    public Facility() {

    }
}
