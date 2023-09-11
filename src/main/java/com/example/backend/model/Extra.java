package com.example.backend.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Extra extends BaseModel {
    String name;
    String description;
    float price;
    boolean perDay;
    boolean perVisit;
    boolean perPerson;
    boolean perPiece;

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
