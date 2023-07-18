package com.example.entitiesexercise1.data;

import jakarta.persistence.Entity;

@Entity
public class Flower extends Plant {
    private String color;

    public Flower() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
