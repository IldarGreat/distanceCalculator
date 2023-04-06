package ru.ildar_technology.task.service.interfaces;

import ru.ildar_technology.task.model.dto.DistanceDto;

public interface CalculatorService {
    DistanceDto getDistance(String type, String fromCityName, String toCityName);
}
