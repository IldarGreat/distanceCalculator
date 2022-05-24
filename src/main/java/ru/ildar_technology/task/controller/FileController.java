package ru.ildar_technology.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.ildar_technology.task.domain.City;
import ru.ildar_technology.task.domain.Distance;
import ru.ildar_technology.task.domain.Storage;
import ru.ildar_technology.task.repository.CityRepository;
import ru.ildar_technology.task.repository.DistanceRepository;
import ru.ildar_technology.task.service.FileStorageParser;
import ru.ildar_technology.task.service.FileStorageService;


import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class FileController {

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private FileStorageParser storageParser;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DistanceRepository distanceRepository;

    @PostMapping("/uploadFile")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileStorageService.storeFile(file);
            Storage unmarshData = storageParser.parseData();
            System.out.println(unmarshData);
            cityRepository.saveAll(unmarshData.getCityList());
            List<Distance> distanceList = unmarshData.getDistanceList();
            List<City> toCityList = new ArrayList<>();
            List<City> fromCityList = new ArrayList<>();
            List<City> cities = cityRepository.findAll();
            for (Distance distance : distanceList) {
                toCityList.add(distance.getToCity());
                fromCityList.add(distance.getFromCity());
            }
            for(City city:cities){

            }
            //  distanceRepository.saveAll(unmarshData.getDistanceList());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
