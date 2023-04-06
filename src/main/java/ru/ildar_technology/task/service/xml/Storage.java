package ru.ildar_technology.task.service.xml;

import ru.ildar_technology.task.model.domain.City;
import ru.ildar_technology.task.model.domain.Distance;

import java.util.List;

public interface Storage {
    List<City> getCityList();
    List<Distance> getDistanceList();
}
