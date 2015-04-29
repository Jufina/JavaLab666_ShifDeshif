package com.miet.mp34.samoshchenko.lab2;

public class Liquid extends Ingredient {
    private int strength;
    public int getStrength() {
        return strength;
    }
    public Liquid(String name, int strength) {
        super(name);
        this.strength=strength;
    }
    public void setStrength(int strength) {
        this.strength=strength;
    }

    public String toString() {
        return super.toString()+" "+strength+"%";
    }

}