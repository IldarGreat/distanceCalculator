package ru.magenta_technology.test_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.magenta_technology.test_task.domain.Storage;
import ru.magenta_technology.test_task.repository.CityRepository;
import ru.magenta_technology.test_task.repository.DistanceRepository;
import ru.magenta_technology.test_task.service.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;


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
          //  distanceRepository.saveAll(unmarshData.getDistanceList());
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
