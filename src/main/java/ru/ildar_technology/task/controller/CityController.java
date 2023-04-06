package ru.ildar_technology.task.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ildar_technology.task.model.dto.CityDto;
import ru.ildar_technology.task.service.interfaces.CityService;

import java.util.List;


@RestController
@RequestMapping("/api")
@Tag(name = "City")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    @Operation(summary = "Возвращает список всех городов")
    public ResponseEntity<List<CityDto>> getCities() {
        return ResponseEntity.ok(cityService.getCities());
    }

}
