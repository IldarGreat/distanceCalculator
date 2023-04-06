package ru.ildar_technology.task.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.ildar_technology.task.service.interfaces.DistanceService;


@RestController
@RequestMapping("/api")
@Tag(name = "File")
public class FileController {

    private final DistanceService distanceService;

    public FileController(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @PostMapping("/uploadFile")
    @Operation(summary = "Позволяет загрузить, затем спарсить загруженный файл и залить его в бд")
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) {
        distanceService.saveAll(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
