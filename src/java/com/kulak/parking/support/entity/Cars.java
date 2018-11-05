package com.kulak.parking.support.entity;

import com.kulak.parking.support.entity.car.Car;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(Car.class)
public class Cars extends ArrayList<Car> {
    public Cars() {
        super();
    }

    public Cars(List<Car> cars){
        super();
        addAll(cars);
    }

    @XmlElement(name = "car")
    public List<Car> getCars() {
        return this;
    }
}
