package com.kulak.parking.support.dao;

import com.kulak.parking.support.entity.Cars;
import com.kulak.parking.support.entity.car.Car;
import com.kulak.parking.support.service.CarService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBDao implements CarService {
    File file = new File("cars.xml");
    private JAXBContext context;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    @Override
    public List<Car> getCars() {
        List<Car> cars = new Cars();
        try {
            context = JAXBContext.newInstance(Cars.class);
            unmarshaller = context.createUnmarshaller();
            cars = (Cars) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public void addCars(List<Car> cars) {
        try {
            context = JAXBContext.newInstance(Cars.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new Cars(cars), file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
