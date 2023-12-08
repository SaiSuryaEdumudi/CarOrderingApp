package org.example.carOrder.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.carOrder.service.Car;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseCar implements Car {
    private String model;
    private List<String> features;
    private double cost;

    public BaseCar(String model, double cost) {
        this.model = model;
        this.cost = cost;
    }

    @Override
    public String getDescription() {
        return "Car " + model + " : $" + cost;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
