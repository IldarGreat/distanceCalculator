package ru.ildar_technology.task.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.ildar_technology.task.model.domain.City;
import ru.ildar_technology.task.model.domain.Distance;
import ru.ildar_technology.task.repository.CityRepository;
import ru.ildar_technology.task.repository.DistanceRepository;
import ru.ildar_technology.task.service.interfaces.DistanceService;
import ru.ildar_technology.task.service.xml.Storage;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistanceServiceImpl implements DistanceService {

    private final FileStorageService fileStorageService;
    private final FileStorageParser storageParser;
    private final CityRepository cityRepository;
    private final DistanceRepository distanceRepository;

    @Override
    public void saveAll(MultipartFile file) {
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
            for (City city : cities) {

            }
            //  distanceRepository.saveAll(unmarshData.getDistanceList());

        } catch (IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAll(List<Distance> distances) {

    }
}
