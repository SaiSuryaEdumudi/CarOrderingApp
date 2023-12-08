package org.example.carOrder.service;

import org.antlr.v4.runtime.misc.Pair;
import org.example.carOrder.entity.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarService {

    public List<String> getAvailableModels() {
        return Arrays.asList("C - $32000", "E - $45000", "CS - $60000");
    }

    public List<String> getAvailableFeatures() {
        return Arrays.asList("Sun Roof", "V-8 Engine", "V-12 Engine",
                "Spare Tire", "Oversized Gas Tank", "Blaupunkt New York 800 Radio");
    }

    public Pair calculatePrice(BaseCar baseCar) {
        Car car = null;
        // calculate
        String model = baseCar.getModel();
        switch (model.toUpperCase()) {
            case "C - $32000":
                car = new BaseCar("C", 32000);
                break;
            case "E - $45000":
                car = new BaseCar("E", 45000);
                break;
            case "CS - $60000":
                car = new BaseCar("CS", 60000);
                break;
        }

        for (String feature : baseCar.getFeatures()) {
            assert car != null;
            switch (feature.toUpperCase()) {
                case "V-8 ENGINE":
                    car = new V8Engine(car);
                    break;
                case "V-12 ENGINE":
                    car = new V12Engine(car);
                    break;
                case "SUN ROOF":
                    car = new SunRoof(car, getModelFactor(model));
                    break;
                case "OVERSIZED GAS TANK":
                    car = new OversizedGasTank(car);
                    break;
                case "BLAUPUNKT NEW YORK 800 RADIO":
                    car = new BlaupunktNewYork800Radio(car);
                    break;
                case "SPARE TIRE":
                    car = new SpareTire(car);
                    break;
            }
        }

        Pair<String, Double> stringDoublePair;
        stringDoublePair = new Pair<>(car.getDescription(), car.getCost());
        return stringDoublePair;
    }

    private static int getModelFactor(String model) {
        return switch (model.toUpperCase()) {
            case "E - $45000" -> 2;
            case "CS - $60000" -> 3;
            default -> 1;
        };
    }
}

