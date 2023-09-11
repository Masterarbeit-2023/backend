package com.example.backend.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Rating extends BaseModel {
    public float score;
    public int location;
    public int room;
    public int service;
    public int pricePerformanceRatio;
    public int comfort;
    public int equipment;
    public int building;
    public int breakfast;
    public int food;
    public int cleanliness;
    public String description;
    public String name;
    public String dateRating;

    public Rating(){}

    public Rating(float score, int location, int room, int service, int pricePerformanceRatio, int comfort, int equipment, int building, int breakfast, int food, int cleanliness) {
        this.score = score;
        this.location = location;
        this.room = room;
        this.service = service;
        this.pricePerformanceRatio = pricePerformanceRatio;
        this.comfort = comfort;
        this.equipment = equipment;
        this.building = building;
        this.breakfast = breakfast;
        this.food = food;
        this.cleanliness = cleanliness;
    }

    public Rating(float score, int location, int room, int service, int pricePerformanceRatio, int comfort, int equipment, int building, int breakfast, int food, int cleanliness, String description, String name, String dateRating) {
        this.score = score;
        this.location = location;
        this.room = room;
        this.service = service;
        this.pricePerformanceRatio = pricePerformanceRatio;
        this.comfort = comfort;
        this.equipment = equipment;
        this.building = building;
        this.breakfast = breakfast;
        this.food = food;
        this.cleanliness = cleanliness;
        this.description = description;
        this.name = name;
        this.dateRating = dateRating;
    }
}
