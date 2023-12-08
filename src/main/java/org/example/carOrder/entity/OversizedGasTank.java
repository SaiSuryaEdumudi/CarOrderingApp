package org.example.carOrder.entity;

import org.example.carOrder.service.Car;

public class OversizedGasTank extends CarDecorator {
    public OversizedGasTank(Car decoratedCar) {
        super(decoratedCar);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Oversized Gas Tank";
    }

    @Override
    public double getCost() {
        return super.getCost() + 940;
    }
}
