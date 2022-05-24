package ru.ildar_technology.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ildar_technology.task.domain.City;
import ru.ildar_technology.task.repository.CityRepository;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityRepository.findAll();
    }

}
