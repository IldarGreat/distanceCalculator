package ru.ildar_technology.task.calculator;

import ru.ildar_technology.task.domain.City;
import ru.ildar_technology.task.domain.Distance;

public interface Calculator {
    Distance getDistance(City fromCity, City toCity);
}
