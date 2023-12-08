package org.example.carOrder.entity;

import org.example.carOrder.service.Car;

public class BlaupunktNewYork800Radio extends CarDecorator {
    public BlaupunktNewYork800Radio(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Blaupunkt New York 800 Radio";
    }

    @Override
    public double getCost() {
        return super.getCost() + 940;
    }
}
