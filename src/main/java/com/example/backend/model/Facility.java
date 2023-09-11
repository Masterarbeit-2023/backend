package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Facility extends BaseModel {

    public String name;

    public Facility(String name) {
        this.name = name;
    }

    public Facility() {

    }
}
