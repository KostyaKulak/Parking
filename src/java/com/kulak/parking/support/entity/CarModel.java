package com.kulak.parking.support.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarModel {
    private String modelLine;
    private String modelNumber;

    public CarModel(){

    }

    public CarModel(String modelLine, String modelNumber) {
        this.modelLine = modelLine;
        this.modelNumber = modelNumber;
    }

    public String getModelLine() {
        return modelLine;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    @XmlAttribute
    public void setModelLine(String modelLine) {
        this.modelLine = modelLine;
    }

    @XmlAttribute
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Override
    public String toString() {
        return this.modelLine + " " + modelNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarModel carModel = (CarModel) o;

        if (modelLine != null ? !modelLine.equals(carModel.modelLine) : carModel.modelLine != null) return false;
        return modelNumber != null ? modelNumber.equals(carModel.modelNumber) : carModel.modelNumber == null;
    }

}
