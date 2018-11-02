package com.kulak.parking.support.entity.car;

import com.kulak.parking.support.entity.CarBrands;
import com.kulak.parking.support.entity.CarModel;

import java.util.List;

public class Volkswagen extends Car {
    public Volkswagen(double pricePerOneKm, CarModel model, int year, List<String> features, double carPrice, double fuelConsumptionPerTenKm) {
        super(pricePerOneKm, model, CarBrands.VOLKSWAGEN, year, features, carPrice, fuelConsumptionPerTenKm);
    }
}
