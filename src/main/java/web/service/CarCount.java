package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.controller.CarController;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarCount {
    public static List<Car> countCars(Integer count, List<Car> list) {

        List<Car> listNew = new ArrayList<>();

        if (count > 5) return list;

        return list.stream().limit(count).collect(Collectors.toList());
    }
}
