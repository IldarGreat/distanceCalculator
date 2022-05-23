package ru.magenta_technology.test_task.calculator;

import ru.magenta_technology.test_task.domain.City;
import ru.magenta_technology.test_task.domain.Distance;

public interface Calculator {
    Distance getDistance(City fromCity, City toCity);
}
