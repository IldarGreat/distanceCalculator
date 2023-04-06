package ru.ildar_technology.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ildar_technology.task.model.dto.CityDto;
import ru.ildar_technology.task.service.interfaces.CityService;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityDto>> getCities() {
        return ResponseEntity.ok(cityService.getCities());
    }

}
