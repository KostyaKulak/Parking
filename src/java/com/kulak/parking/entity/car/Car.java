package com.kulak.parking.entity.car;

import com.kulak.parking.entity.Vehicle;

public class Car extends Vehicle {
    private double pricePerOneKm;
    private String brand;
    private double fuelСonsumptionPerTenKm;

    public Car(double pricePerOneKm, String brand, double fuelСonsumptionPerTenKm) {
        this.pricePerOneKm = pricePerOneKm;
        this.brand = brand;
        this.fuelСonsumptionPerTenKm = fuelСonsumptionPerTenKm;
    }

    public Car(double pricePerOneKm, double fuelСonsumptionPerTenKm) {
        this.pricePerOneKm = pricePerOneKm;
        this.fuelСonsumptionPerTenKm = fuelСonsumptionPerTenKm;
    }

    public double getPricePerOneKm() {
        return pricePerOneKm;
    }

    public String getBrand() {
        return brand;
    }

    public double getFuelСonsumptionPerTenKm() {
        return fuelСonsumptionPerTenKm;
    }

    public void setPricePerOneKm(double pricePerOneKm) {
        this.pricePerOneKm = pricePerOneKm;
    }
}
