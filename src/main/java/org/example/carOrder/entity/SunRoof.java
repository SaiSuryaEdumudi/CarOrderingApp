package org.example.carOrder.entity;

import org.example.carOrder.service.Car;

public class SunRoof extends CarDecorator {
    private int modelFactor;

    public SunRoof(Car decoratedCar, int modelFactor) {
        super(decoratedCar);
        this.modelFactor = modelFactor;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with Sun Roof";
    }

    @Override
    public double getCost() {
        if (modelFactor == 1)
            return super.getCost() + 1940;
        else if (modelFactor == 2)
            return super.getCost() + 2240;
        else
            return super.getCost() + 3400;

    }
}
