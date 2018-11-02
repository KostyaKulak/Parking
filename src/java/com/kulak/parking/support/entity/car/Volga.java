package com.kulak.parking.support.entity.car;

import com.kulak.parking.support.entity.CarBrands;
import com.kulak.parking.support.entity.CarModel;

import java.util.List;

public class Volga extends Car {
    public Volga(double pricePerOneKm, CarModel model, int year, List<String> features, double carPrice, double fuelConsumptionPerTenKm) {
        super(pricePerOneKm, model, CarBrands.VOLGA, year, features, carPrice, fuelConsumptionPerTenKm);
    }
}
