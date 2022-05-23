package ru.magenta_technology.test_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.magenta_technology.test_task.calculator.*;
import ru.magenta_technology.test_task.domain.*;
import ru.magenta_technology.test_task.exception.*;
import ru.magenta_technology.test_task.repository.*;


import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    @Qualifier("distanceMatrixCalculator")
    private Calculator distanceMatrixCalculator;

    @Autowired
    @Qualifier("crowFlightCalculator")
    private Calculator crowFlightCalculator;

    @GetMapping("/calculate/{type}/{from_city}/{to_city}")
    public Distance getDistance(@PathVariable("type") String type, @PathVariable("from_city") String fromCityName,
                                @PathVariable("to_city") String toCityName) {
        if (!type.equals("Crowflight") && !type.equals("Distance Matrix")) {
            throw new NoSuchTypeException("There is no such type of calculation as " + type);
        }
        Optional<City> fromCityCandidate = cityRepository.findByName(fromCityName);
        Optional<City> toCityCandidate = cityRepository.findByName(toCityName);
        if (fromCityCandidate.isEmpty() || toCityCandidate.isEmpty()) {
            throw new NoSuchEntityException("There are no such cities as " + fromCityName + " or " +
                    toCityName + " in the database");
        }
        if (type.equals("Crowflight")) {
            return crowFlightCalculator.getDistance(fromCityCandidate.get(), toCityCandidate.get());
        } else {
            return distanceMatrixCalculator.getDistance(fromCityCandidate.get(), toCityCandidate.get());
        }
    }

}
