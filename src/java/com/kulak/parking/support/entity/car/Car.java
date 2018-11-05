package com.kulak.parking.support.entity.car;

import com.kulak.parking.support.entity.CarModel;
import com.kulak.parking.support.entity.Driverable;
import com.kulak.parking.support.entity.Vehicle;
import com.kulak.parking.support.exception.CarPriceException;
import com.kulak.parking.support.exception.PricePerOneKmException;
import com.kulak.parking.support.exception.YearException;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(CarModel.class)
public class Car extends Vehicle implements Driverable {
    private double pricePerOneKm;
    private CarModel model;
    private String brand;
    private int year;
    private double carPrice;
    private double fuelConsumptionPerTenKm;
    private List<String> features;

    public Car(){

    }

    public Car(double pricePerOneKm, CarModel model, String brand, int year, List<String> features, double carPrice, double fuelConsumptionPerTenKm) {
        if (pricePerOneKm < 0) {
            throw new PricePerOneKmException("Wrong price for one km");
        }
        this.pricePerOneKm = pricePerOneKm;
        this.model = model;
        this.brand = brand;
        if (year < 1990) {
            throw new YearException("Wrong year");
        }
        this.year = year;
        this.features = features;
        if (carPrice < 0) {
            throw new CarPriceException("Wrong price for car");
        }
        this.carPrice = carPrice;
        if (fuelConsumptionPerTenKm < 0)
            throw new RuntimeException("Wrong fuelConsumptionPerTenKm");
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

    @XmlAttribute
    public void setPricePerOneKm(double pricePerOneKm) {
        this.pricePerOneKm = pricePerOneKm;
    }

    public CarModel getModel() {
        return model;
    }

    @XmlElement
    public void setModel(CarModel model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    @XmlAttribute
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    @XmlAttribute
    public void setYear(int year) {
        this.year = year;
    }

    public double getCarPrice() {
        return carPrice;
    }

    @XmlAttribute
    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public double getFuelConsumptionPerTenKm() {
        return fuelConsumptionPerTenKm;
    }

    @XmlAttribute
    public void setFuelConsumptionPerTenKm(double fuelConsumptionPerTenKm) {
        this.fuelConsumptionPerTenKm = fuelConsumptionPerTenKm;
    }

    public List<String> getFeatures() {
        return features;
    }

    @XmlAttribute
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public void addFeature(String feature, double priceOfFeature) {
        this.features.add(feature);
        this.carPrice += priceOfFeature;
    }

    @Override
    public double drive(double way) throws Exception {
        if (pricePerOneKm * way == 0) {
            throw new Exception("Wrong price for way");
        }
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

    public boolean check(double pricePerOneKm1, double pricePerOneKm2, List<CarModel> models, List<String> brands, int year1, int year2, List<String> someFeatures, double carPrice1, double carPrice2, double fuelConsumptionPerTenKm1, double fuelConsumptionPerTenKm2) {
        boolean isSuitable = false;
        if (pricePerOneKm <= pricePerOneKm2 && pricePerOneKm >= pricePerOneKm1) {
            if (models.contains(model)) {
                if (brands.contains(brand)) {
                    if (year <= year2 && year >= year1) {
                        boolean isFeaturesPresent = true;
                        for (String feature : someFeatures) {
                            if (!features.contains(feature)) {
                                isFeaturesPresent = false;
                                break;
                            }
                        }
                        if (isFeaturesPresent) {
                            if (carPrice <= carPrice2 && carPrice >= carPrice1) {
                                if (fuelConsumptionPerTenKm <= fuelConsumptionPerTenKm2 && fuelConsumptionPerTenKm >= fuelConsumptionPerTenKm1) {
                                    isSuitable = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return isSuitable;
    }

}
