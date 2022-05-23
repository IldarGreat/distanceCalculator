package ru.magenta_technology.test_task.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.magenta_technology.test_task.domain.*;
import ru.magenta_technology.test_task.exception.NoSuchEntityException;
import ru.magenta_technology.test_task.repository.DistanceRepository;



@Component
public class DistanceMatrixCalculator implements Calculator {

    @Autowired
    private DistanceRepository distanceRepository;

    @Override
    public Distance getDistance(City fromCity, City toCity) {
        return distanceRepository.findByFromCityAndToCity(fromCity, toCity).orElseGet(() ->
                distanceRepository.findByFromCityAndToCity(toCity, fromCity)
                        .orElseThrow(() ->
                                new NoSuchEntityException("There are no matching entities in the distance table")));
    }
}
