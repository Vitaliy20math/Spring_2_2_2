package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarServiceImpl implements CarService {
    @Override
    public List<Car> countCars(Integer count, List<Car> list) {

        list.add(new Car("BMW", "SUV", 7));
        list.add(new Car("Mazda", "Sedan", 5));
        list.add(new Car("Nexia", "Micro", 4));
        list.add(new Car("Audi", "Sport", 4));
        list.add(new Car("Lada", "Sedan", 6));

        if (count > 5) return list;

        return list.stream().limit(count).collect(Collectors.toList());
    }


}
