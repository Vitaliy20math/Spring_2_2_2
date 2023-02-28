package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;
import web.service.CarServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private CarServiceImpl carService;
    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }
    @GetMapping(value = "/cars")
    public String getCar(@RequestParam(defaultValue = "5", value = "count") Integer count, Model model) {
        List<Car> list = new ArrayList<>();
        list = carService.countCars(count, list);
        model.addAttribute("table", list);

        return "cars";
    }
}
