package com.example.entitiesexercise1.data;

import jakarta.persistence.Entity;

@Entity
public class Shrub extends Plant {
    private int heightCm;
    private int widthCm;

    public int getHeightCm() {
        return heightCm;
    }

    public void setHeightCm(int height) {
        this.heightCm = height;
    }

    public int getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(int width) {
        this.widthCm = width;
    }
}
