package com.kulak.parking;

import com.kulak.parking.support.dao.FileDao;
import com.kulak.parking.support.dao.JAXBDao;
import com.kulak.parking.support.dao.MySQLDao;
import com.kulak.parking.support.service.CarService;
import com.kulak.parking.support.util.CarComparator;
import com.kulak.parking.support.entity.CarBrands;
import com.kulak.parking.support.entity.CarModel;
import com.kulak.parking.support.entity.car.Audi;
import com.kulak.parking.support.entity.car.Car;
import com.kulak.parking.support.entity.car.Mercedes;
import com.kulak.parking.support.entity.car.Volga;

import java.util.ArrayList;
import java.util.List;

public class ExecuteTasks {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Mercedes(5.0, new CarModel("E", "W211"), 2013, new ArrayList<>(), 30000, 6.5));
        cars.add(new Volga(3.0, new CarModel("", ""), 1998, new ArrayList<>(), 2000, 10.5));
        List<String> features = new ArrayList<>();
        features.add("TV");
        features.add("WI-FI");
        cars.add(new Audi(10.0, new CarModel("A", "8"), 2018, features, 60000, 8.5));
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        cars.sort(new CarComparator());
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        List<CarModel> carModels = new ArrayList<>();
        carModels.add(new CarModel("E", "W211"));
        carModels.add(new CarModel("A", "8"));
        List<String> carBrands = new ArrayList<>();
        carBrands.add(CarBrands.AUDI);
        carBrands.add(CarBrands.MERCEDES);
        for (Car car : cars) {
            if (car.check(3.0, 10.0, carModels, carBrands, 1998, 2018, features, 2000, 60000, 5.5, 9.5)) {
                System.out.println("Your car is " + car.toString());
            }
        }
        CarService carService = new FileDao();
        carService.addCars(cars);
        System.out.println("Cars from usual file:");
        for (Car car : carService.getCars()) {
            System.out.println(car.toString());
        }
        carService = new JAXBDao();
        carService.addCars(cars);
        System.out.println("Cars from xml file:");
        for (Car car : carService.getCars()) {
            System.out.println(car.toString());
        }
        carService = new MySQLDao();
        carService.addCars(cars);
        System.out.println("Cars from mysql db:");
        for (Car car : carService.getCars()) {
            System.out.println(car.toString());
        }
    }
}
