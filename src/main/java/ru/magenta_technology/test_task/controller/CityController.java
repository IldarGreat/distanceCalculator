package ru.magenta_technology.test_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.magenta_technology.test_task.domain.City;
import ru.magenta_technology.test_task.repository.CityRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable int id) {
        Optional<City> cityCandidate = cityRepository.findById((long) id);
        return cityCandidate.orElse(null);
    }
}
