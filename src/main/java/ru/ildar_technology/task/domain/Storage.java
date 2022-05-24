package ru.ildar_technology.task.domain;

import java.util.List;

public interface Storage {
    List<City> getCityList();
    List<Distance> getDistanceList();
}
