package org.example.carOrder.controller;

import org.antlr.v4.runtime.misc.Pair;
import org.example.carOrder.entity.BaseCar;
import org.example.carOrder.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("car", new BaseCar());
        model.addAttribute("models", carService.getAvailableModels());
        model.addAttribute("features", carService.getAvailableFeatures());
        return "index";
    }

    @PostMapping("/calculatePrice")
    public String calculatePrice(@ModelAttribute BaseCar car, Model model) {
        Pair resultPair = carService.calculatePrice(car);
        model.addAttribute("description", resultPair.a);
        model.addAttribute("totalPrice", resultPair.b);
        return "result";
    }
}

