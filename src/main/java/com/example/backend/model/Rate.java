package com.example.backend.model;

public class Rate {
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
}
