package com.kulak.parking.support;

import com.kulak.parking.support.entity.car.Car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return Double.compare(o2.getFuelConsumptionPerTenKm(), o1.getFuelConsumptionPerTenKm());
    }
}