package com.kulak.parking;

import com.kulak.parking.support.CarComparator;
import com.kulak.parking.support.entity.CarModel;
import com.kulak.parking.support.entity.car.Audi;
import com.kulak.parking.support.entity.car.Car;
import com.kulak.parking.support.entity.car.Mercedes;
import com.kulak.parking.support.entity.car.Volga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExecuteTasks {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Mercedes(5.0, new CarModel("E", "W211"), 2013, new ArrayList<>(),30000, 6.5));
        cars.add(new Volga(3.0, new CarModel("", ""), 1998, new ArrayList<>(),2000, 10.5));
        List<String> features = new ArrayList<>();
        features.add("TV");
        cars.add(new Audi(10.0, new CarModel("A", "8"), 2018, features,60000, 8.5));
        for (Car car: cars){
            System.out.println(car.toString());
        }
        cars.sort(new CarComparator());
        for (Car car: cars){
            System.out.println(car.toString());
        }
    }
}
