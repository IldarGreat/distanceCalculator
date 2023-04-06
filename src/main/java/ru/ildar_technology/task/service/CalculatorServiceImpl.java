package ru.ildar_technology.task.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ildar_technology.task.exception.custom.NoSuchEntityException;
import ru.ildar_technology.task.exception.custom.NoSuchTypeException;
import ru.ildar_technology.task.model.domain.City;
import ru.ildar_technology.task.model.domain.Distance;
import ru.ildar_technology.task.model.dto.DistanceDto;
import ru.ildar_technology.task.model.mapper.DistanceMapper;
import ru.ildar_technology.task.repository.CityRepository;
import ru.ildar_technology.task.repository.DistanceRepository;
import ru.ildar_technology.task.service.interfaces.CalculatorService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {
    private final CityRepository cityRepository;
    private final DistanceRepository distanceRepository;
    private final DistanceMapper distanceMapper;

    @Override
    public DistanceDto getDistance(String type, String fromCityName, String toCityName) {
        if (!type.equals("Crowflight") && !type.equals("Distance Matrix")) {
            throw new NoSuchTypeException("There is no such type of calculation as " + type);
        }
        Optional<City> fromCityCandidate = cityRepository.findByName(fromCityName);
        Optional<City> toCityCandidate = cityRepository.findByName(toCityName);
        if (fromCityCandidate.isEmpty() || toCityCandidate.isEmpty()) {
            throw new NoSuchEntityException("There are no such cities as " + fromCityName + " or " +
                    toCityName + " in the database");
        }
        if (type.equals("Crowflight")) {
            return getDistanceCrowFlight(fromCityCandidate.get(), toCityCandidate.get());
        } else {
            return getDistanceFromMatrix(fromCityCandidate.get(), toCityCandidate.get());
        }
    }

    private DistanceDto getDistanceCrowFlight(City fromCity, City toCity) {
        Double fromCityLatitude = Double.parseDouble(new StringBuilder(fromCity.getLatitude()).substring(0, 5));
        Double toCityLatitude = Double.parseDouble(new StringBuilder(toCity.getLatitude()).substring(0, 5));
        char latitudePlaceFromCity = new StringBuilder(fromCity.getLatitude()).charAt(5);
        char latitudePlaceToCity = new StringBuilder(toCity.getLatitude()).charAt(5);
        double latitudeDifference;
        if (latitudePlaceFromCity != latitudePlaceToCity) {
            latitudeDifference = fromCityLatitude + toCityLatitude;
        } else {
            latitudeDifference = Math.abs(fromCityLatitude - toCityLatitude);
        }
        double ONE_DEGREE_LATITUDE = 111.16;
        double A = ONE_DEGREE_LATITUDE * latitudeDifference;

        Double fromCityLongitude = Double.parseDouble(new StringBuilder(fromCity.getLongitude()).substring(0, 5));
        Double toCityLongitude = Double.parseDouble(new StringBuilder(toCity.getLongitude()).substring(0, 5));
        char longitudePlaceFromCity = new StringBuilder(fromCity.getLongitude()).charAt(5);
        char longitudePlaceToCity = new StringBuilder(toCity.getLongitude()).charAt(5);
        double longitudeDifference;
        if (longitudePlaceFromCity != longitudePlaceToCity) {
            longitudeDifference = fromCityLongitude + toCityLongitude;
        } else {
            longitudeDifference = Math.abs(fromCityLongitude - toCityLongitude);
        }

        double ONE_DEGREE_LONGITUDE = 111.3;
        double B = longitudeDifference * ONE_DEGREE_LONGITUDE * Math.cos(Math.toRadians(Math.min(fromCityLatitude, toCityLatitude)));
        double EARTH_RADIUS = 6400;
        double distance = EARTH_RADIUS * Math.sqrt(Math.pow(A / EARTH_RADIUS, 2) + Math.pow(B / EARTH_RADIUS, 2));
        return distanceMapper.toDto(new Distance(fromCity, toCity, distance));
    }

    private DistanceDto getDistanceFromMatrix(City fromCity, City toCity) {
        Distance distance = distanceRepository.findByFromCityAndToCity(fromCity, toCity).orElseGet(() ->
                distanceRepository.findByFromCityAndToCity(toCity, fromCity)
                        .orElseThrow(() ->
                                new NoSuchEntityException("There are no matching entities in the distance table")));
        return distanceMapper.toDto(distance);
    }
}
