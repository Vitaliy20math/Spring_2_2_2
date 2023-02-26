package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarCount;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String getCar(@RequestParam(defaultValue = "5", value = "count") Integer count, Model model) {
        List<Car> list = new ArrayList<>();
        list.add(new Car("BMW", "SUV", 7));
        list.add(new Car("Mazda", "Sedan", 5));
        list.add(new Car("Nexia", "Micro", 4));
        list.add(new Car("Audi", "Sport", 4));
        list.add(new Car("Lada", "Sedan", 6));
        list = CarCount.countCars(count, list);
        model.addAttribute("table", list);

        return "cars";
    }
}
