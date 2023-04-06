package ru.ildar_technology.task.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ildar_technology.task.model.dto.DistanceDto;
import ru.ildar_technology.task.service.interfaces.CalculatorService;

@RestController
@RequestMapping("/api")
public class CalculatorController {
    private final CalculatorService calculator;

    public CalculatorController(CalculatorService calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/calculate/{type}/{from_city}/{to_city}")
    public ResponseEntity<DistanceDto> getDistance(@PathVariable("type") String type, @PathVariable("from_city") String fromCityName,
                                                   @PathVariable("to_city") String toCityName) {
        return ResponseEntity.ok(calculator.getDistance(type, fromCityName, toCityName));
    }

}
