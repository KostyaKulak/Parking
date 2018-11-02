package com.kulak.parking.support.entity.car;

import com.kulak.parking.support.entity.CarBrands;
import com.kulak.parking.support.entity.CarModel;

import java.util.List;

public class Mercedes extends Car {

    public Mercedes(double pricePerHour, CarModel model, int year, List<String> features, double carPrice, double fuelConsumptionPerTenKm) {
        super(pricePerHour, model,CarBrands.MERCEDES, year, features, carPrice, fuelConsumptionPerTenKm);
    }
}
