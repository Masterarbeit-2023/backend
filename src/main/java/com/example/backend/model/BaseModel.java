package com.example.backend.model;

import jakarta.persistence.*;
@Entity
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long id;
}
