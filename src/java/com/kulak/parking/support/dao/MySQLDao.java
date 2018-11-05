package com.kulak.parking.support.dao;

import com.kulak.parking.support.entity.CarBrands;
import com.kulak.parking.support.entity.CarModel;
import com.kulak.parking.support.entity.car.*;
import com.kulak.parking.support.service.CarService;
import com.kulak.parking.support.service.ResourceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MySQLDao extends DAO implements CarService {

    @Override
    public List<Car> getCars() {
        List<Car> cars = new ArrayList<>();
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(ResourceService.SQL_GET_ALL_CARS));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car car = null;
                String model = resultSet.getString("model");
                List<String> features = null;
                try {
                    features = Arrays.asList(resultSet.getString("features").split(" "));
                }catch (NullPointerException ignored){
                }
                switch (resultSet.getString("brand")) {
                    case CarBrands.AUDI:
                        car = new Audi(resultSet.getDouble("pricePerOneKm"), new CarModel(model.split(" ")[0], model.split(" ")[1]), resultSet.getInt("year"),
                               features , resultSet.getDouble("carPrice"), resultSet.getDouble("fuelConsumptionPerTenKm"));
                        break;
                    case CarBrands.BMW:
                        car = new BMW(resultSet.getDouble("pricePerOneKm"), new CarModel(model.split(" ")[0], model.split(" ")[1]), resultSet.getInt("year"),
                                features , resultSet.getDouble("carPrice"), resultSet.getDouble("fuelConsumptionPerTenKm"));
                        break;
                    case CarBrands.MERCEDES:
                        car = new Mercedes(resultSet.getDouble("pricePerOneKm"), new CarModel(model.split(" ")[0], model.split(" ")[1]), resultSet.getInt("year"),
                                features , resultSet.getDouble("carPrice"), resultSet.getDouble("fuelConsumptionPerTenKm"));
                        break;
                    case CarBrands.VOLGA:
                        car = new Volga(resultSet.getDouble("pricePerOneKm"), new CarModel("", ""), resultSet.getInt("year"),
                                features , resultSet.getDouble("carPrice"), resultSet.getDouble("fuelConsumptionPerTenKm"));
                        break;
                    case CarBrands.VOLKSWAGEN:
                        car = new Volkswagen(resultSet.getDouble("pricePerOneKm"), new CarModel(model.split(" ")[0], model.split(" ")[1]), resultSet.getInt("year"),
                                features , resultSet.getDouble("carPrice"), resultSet.getDouble("fuelConsumptionPerTenKm"));
                        break;
                    default:
                        car = new Car(resultSet.getDouble("pricePerOneKm"), new CarModel(model.split(" ")[0], model.split(" ")[1]), resultSet.getInt("year"),
                                features , resultSet.getDouble("carPrice"), resultSet.getDouble("fuelConsumptionPerTenKm"));
                        break;
                }
                cars.add(car);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
        return cars;
    }

    @Override
    public void addCars(List<Car> cars) {
        for (Car car : cars) {
            addCar(car);
        }
    }

    private void addCar(Car car) {
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(ResourceService.SQL_ADD_CAR));
            statement.setDouble(1, car.getPricePerOneKm());
            statement.setString(2, car.getModel().getModelLine() + " " + car.getModel().getModelNumber());
            statement.setString(3, car.getBrand());
            statement.setInt(4, car.getYear());
            StringBuilder stringBuilder = new StringBuilder();
            for (String string : car.getFeatures()) {
                stringBuilder.append(string).append(" ");
            }
            statement.setString(5, stringBuilder.toString().trim());
            statement.setDouble(6, car.getCarPrice());
            statement.setDouble(7, car.getFuelConsumptionPerTenKm());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolInst.footConnection(connection);
        }
    }
}