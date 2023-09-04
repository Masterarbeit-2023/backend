package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
public class Rate extends BaseModel {
    public String name;
    public boolean member;
    public String[] benefits;
    public float price;

    public Rate(String name, boolean member, String[] benefits, float price) {
        this.name = name;
        this.member = member;
        this.benefits = benefits;
        this.price = price;
    }

    public Rate() {

    }
}
