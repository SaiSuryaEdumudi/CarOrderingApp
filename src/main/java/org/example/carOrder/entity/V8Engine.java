package org.example.carOrder.entity;

import org.example.carOrder.service.Car;

public class V8Engine extends CarDecorator {
    public V8Engine(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with V-8";
    }

    @Override
    public double getCost() {
        return super.getCost() + 4400;
    }
}
