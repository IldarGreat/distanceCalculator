package ru.magenta_technology.test_task.domain;

import java.util.List;

public interface Storage {
    List<City> getCityList();
    List<Distance> getDistanceList();
}
