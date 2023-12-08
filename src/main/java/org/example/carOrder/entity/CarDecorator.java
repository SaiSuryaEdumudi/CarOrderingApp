package org.example.carOrder.entity;

import org.example.carOrder.service.Car;

abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    @Override
    public String getDescription() {
        return decoratedCar.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCar.getCost();
    }
}
