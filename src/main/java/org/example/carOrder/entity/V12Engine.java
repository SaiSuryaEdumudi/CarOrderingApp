package org.example.carOrder.entity;

import org.example.carOrder.service.Car;

public class V12Engine extends CarDecorator {
    public V12Engine(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with V-12";
    }

    @Override
    public double getCost() {
        return super.getCost() + 6400;
    }
}
