package com.kulak.parking.support.entity.car;

import com.kulak.parking.support.entity.CarBrands;
import com.kulak.parking.support.entity.CarModel;
import com.kulak.parking.support.entity.Driverable;
import com.kulak.parking.support.entity.Vehicle;

import java.util.List;

public class Car extends Vehicle implements Driverable {
    private double pricePerOneKm;
    private CarModel model;
    private CarBrands brand;
    private int year;
    private double carPrice;
    private double fuelConsumptionPerTenKm;
    private List<String> features;

    public Car(double pricePerOneKm, CarModel model, CarBrands brand, int year, List<String> features, double carPrice, double fuelConsumptionPerTenKm) {
        this.pricePerOneKm = pricePerOneKm;
        this.model = model;
        this.brand = brand;
        this.year = year;
        this.features = features;
        this.carPrice = carPrice;
        this.fuelConsumptionPerTenKm = fuelConsumptionPerTenKm;
    }

    public Car(double pricePerOneKm, CarModel model, int year, List<String> features, double carPrice, double fuelConsumptionPerTenKm) {
        this.pricePerOneKm = pricePerOneKm;
        this.model = model;
        this.year = year;
        this.features = features;
        this.carPrice = carPrice;
        this.fuelConsumptionPerTenKm = fuelConsumptionPerTenKm;
    }

    public double getPricePerOneKm() {
        return pricePerOneKm;
    }

    public CarModel getModel() {
        return model;
    }

    public CarBrands getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public List<String> getFeatures() {
        return features;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public double getFuelConsumptionPerTenKm() {
        return fuelConsumptionPerTenKm;
    }

    public void setPricePerOneKm(double pricePerOneKm) {
        this.pricePerOneKm = pricePerOneKm;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public void addFeature(String feature, double priceOfFeature) {
        this.features.add(feature);
        this.carPrice += priceOfFeature;
    }

    @Override
    public double drive(double way) {
        return way * pricePerOneKm;
    }

    @Override
    public String toString() {
        return this.brand.toString() + " " + this.model.toString() + " of " + this.year + " year";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.pricePerOneKm, pricePerOneKm) != 0) return false;
        if (year != car.year) return false;
        if (Double.compare(car.carPrice, carPrice) != 0) return false;
        if (Double.compare(car.fuelConsumptionPerTenKm, fuelConsumptionPerTenKm) != 0) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (brand != car.brand) return false;
        return features != null ? features.equals(car.features) : car.features == null;
    }

    public boolean check(){
        boolean isSuitable = false;

        return isSuitable;
    }

}
