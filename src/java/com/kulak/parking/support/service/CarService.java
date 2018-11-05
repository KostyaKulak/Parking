package com.kulak.parking.support.service;

import com.kulak.parking.support.entity.car.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    void addCars(List<Car> cars);
}
