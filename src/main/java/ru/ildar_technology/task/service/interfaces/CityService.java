package ru.ildar_technology.task.service.interfaces;

import ru.ildar_technology.task.model.dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> getCities();
}
