package org.example.carOrder;

import org.example.carOrder.entity.*;
import org.example.carOrder.service.Car;

import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car car = null;

        while (true) {
            System.out.println("Enter car model (Type 'quit' to exit): ");
            System.out.println("1: C - $32,000");
            System.out.println("2: E - $45,000");
            System.out.println("3: CS - $60,000");
            String model = scanner.nextLine();

            if (model.equalsIgnoreCase("quit")) {
                break;
            }

            switch (model.toUpperCase()) {
                case "C":
                    car = new BaseCar("C", 32000);
                    break;
                case "E":
                    car = new BaseCar("E", 45000);
                    break;
                case "CS":
                    car = new BaseCar("CS", 60000);
                    break;
                default:
                    System.out.println("Invalid car model. Please enter C, E, or CS.");
                    continue;
            }

            while (true) {
                System.out.println("Add Additional Features (Type 'Done' when finished): ");
                System.out.println("1: V-8 Engine - $4,400");
                System.out.println("2: V-12 Engine - $6.400");
                System.out.println("3: Sun Roof -  $1940, $2240, $3400 (C, E and CS respectively)");
                System.out.println("4: Oversized Gas Tank - $940");
                System.out.println("5: Blaupunkt New York 800 Radio - $940");
                System.out.println("6: Spare Tire - $440");

                String option = scanner.nextLine();

                if (option.equalsIgnoreCase("Done")) {
                    break;
                }

                switch (option.toUpperCase()) {
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
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                        break;
                }
            }

            // Print order details
            System.out.println("New Order:");
            System.out.println(car.getDescription());
            System.out.println("Cost: $" + car.getCost());
            System.out.println("End Order\n");
        }

        scanner.close();
    }

    private static int getModelFactor(String model) {
        return switch (model.toUpperCase()) {
            case "E" -> 2;
            case "CS" -> 3;
            default -> 1;
        };
    }
}
