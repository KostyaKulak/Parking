package com.kulak.parking.support.entity;

public enum CarBrands {
    AUDI("Audi"),
    BMW("BMW"),
    MERCEDES("Mercedes"),
    VOLKSWAGEN("Volkswagen"),
    VOLGA("Volga");

    String value;

    CarBrands(String brand) {
        this.value = brand;
    }

    @Override
    public String toString() {
        return value;
    }
}
