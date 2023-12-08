package org.example.carOrder.entity;

import org.example.carOrder.service.Car;

public class SpareTire extends CarDecorator {
    public SpareTire(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Spare Tire : $440 ";
    }

    @Override
    public double getCost() {
        return super.getCost() + 440;
    }
}