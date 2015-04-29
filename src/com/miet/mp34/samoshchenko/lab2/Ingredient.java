package com.miet.mp34.samoshchenko.lab2;

public abstract class Ingredient {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }
    protected Ingredient(String name) {
        this.name=name;
    }
    public String toString() {
        return name;
    }
}
