package com.kulak.parking.support.entity.car;

import com.kulak.parking.support.entity.CarBrands;
import com.kulak.parking.support.entity.CarModel;

import java.util.List;

public class BMW extends Car {

    public BMW(double pricePerHour, CarModel model, int year, List<String> features, double carPrise, double fuelConsumptionPerTenKm) {
        super(pricePerHour, model, CarBrands.BMW, year, features, carPrise, fuelConsumptionPerTenKm);
    }
}
