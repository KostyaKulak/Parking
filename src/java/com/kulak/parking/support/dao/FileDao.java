package com.kulak.parking.support.dao;

import com.kulak.parking.support.entity.CarBrands;
import com.kulak.parking.support.entity.CarModel;
import com.kulak.parking.support.entity.car.*;
import com.kulak.parking.support.service.CarService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDao implements CarService {
    private File file = new File("cars.txt");

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String lineArgs[] = line.split(" ");
            Car car = null;
            switch (lineArgs[3]) {
                case CarBrands.AUDI:
                    car = new Audi(Double.parseDouble(lineArgs[0]), new CarModel(lineArgs[1], lineArgs[2]), Integer.parseInt(lineArgs[4]), new ArrayList<>(), Double.parseDouble(lineArgs[5]), Double.parseDouble(lineArgs[6]));
                    break;
                case CarBrands.BMW:
                    car = new BMW(Double.parseDouble(lineArgs[0]), new CarModel(lineArgs[1], lineArgs[2]), Integer.parseInt(lineArgs[4]), new ArrayList<>(), Double.parseDouble(lineArgs[5]), Double.parseDouble(lineArgs[6]));
                    break;
                case CarBrands.VOLGA:
                    car = new Volga(Double.parseDouble(lineArgs[0]), new CarModel(lineArgs[1], lineArgs[2]), Integer.parseInt(lineArgs[4]), new ArrayList<>(), Double.parseDouble(lineArgs[5]), Double.parseDouble(lineArgs[6]));
                    break;
                case CarBrands.VOLKSWAGEN:
                    car = new Volkswagen(Double.parseDouble(lineArgs[0]), new CarModel(lineArgs[1], lineArgs[2]), Integer.parseInt(lineArgs[4]), new ArrayList<>(), Double.parseDouble(lineArgs[5]), Double.parseDouble(lineArgs[6]));
                    break;
                case CarBrands.MERCEDES:
                    car = new Mercedes(Double.parseDouble(lineArgs[0]), new CarModel(lineArgs[1], lineArgs[2]), Integer.parseInt(lineArgs[4]), new ArrayList<>(), Double.parseDouble(lineArgs[5]), Double.parseDouble(lineArgs[6]));
                    break;
                default:
                    car = new Car(Double.parseDouble(lineArgs[0]), new CarModel(lineArgs[1], lineArgs[2]), "unknown", Integer.parseInt(lineArgs[4]), new ArrayList<>(), Double.parseDouble(lineArgs[5]), Double.parseDouble(lineArgs[6]));
                    break;
            }
            if (lineArgs.length > 7) {
                for (int i = 7; i < lineArgs.length; i++) {
                    try {
                        car.addFeature(lineArgs[i], 0.0);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
            cars.add(car);
        }
        scanner.close();
        return cars;
    }

    @Override
    public void addCars(List<Car> cars) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Car car : cars) {
            printWriter.write(car.getPricePerOneKm() + " " + car.getModel().getModelLine() + " " +
                    car.getModel().getModelNumber() + " " + car.getBrand() + " " +
                    car.getYear() + " " + car.getCarPrice() + " " +
                    car.getFuelConsumptionPerTenKm());
            for (String feature : car.getFeatures()) {
                printWriter.write(" " + feature);
            }
            printWriter.write("\n");
        }
        printWriter.close();
    }
}
