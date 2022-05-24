package ru.ildar_technology.task.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ildar_technology.task.domain.City;
import ru.ildar_technology.task.domain.Distance;
import ru.ildar_technology.task.exception.NoSuchEntityException;
import ru.ildar_technology.task.repository.DistanceRepository;



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
