package com.example.backend.model;

import jakarta.persistence.Entity;

@Entity
public class Extra extends BaseModel {
    public String name;
    public String description;
    public float price;
    public boolean perDay;
    public boolean perVisit;
    public boolean perPerson;
    public boolean perPiece;

    public Extra() {
    }

    public Extra(String name, String description, float price, boolean perDay, boolean perVisit, boolean perPerson, boolean perPiece) {
        assert correctValues(perDay, perVisit, perPerson, perPiece);
        this.name = name;
        this.description = description;
        this.price = price;
        this.perDay = perDay;
        this.perVisit = perVisit;
        this.perPerson = perPerson;
        this.perPiece = perPiece;
    }

    public static boolean correctValues(boolean perDay, boolean perVisit, boolean perPerson, boolean perPiece) {
        return (!perDay || !perVisit) && (!perPerson || !perPiece);
    }
}
