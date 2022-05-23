package ru.magenta_technology.test_task.calculator;

import org.springframework.stereotype.Component;
import ru.magenta_technology.test_task.domain.City;
import ru.magenta_technology.test_task.domain.Distance;

@Component
public class CrowFlightCalculator implements Calculator {

    private final Double ONE_DEGREE_LATITUDE = 111.16;
    private final Double ONE_DEGREE_LONGITUDE = 111.3;
    private Double latitudeDifference;
    private Double longitudeDifference;
    private final double EARTH_RADIUS = 6400;

    @Override
    public Distance getDistance(City fromCity, City toCity) {
        Double fromCityLatitude = Double.parseDouble(new StringBuilder(fromCity.getLatitude()).substring(0, 5));
        Double toCityLatitude = Double.parseDouble(new StringBuilder(toCity.getLatitude()).substring(0, 5));
        char latitudePlaceFromCity = new StringBuilder(fromCity.getLatitude()).charAt(5);
        char latitudePlaceToCity = new StringBuilder(toCity.getLatitude()).charAt(5);
        if (latitudePlaceFromCity != latitudePlaceToCity) {
            latitudeDifference = fromCityLatitude + toCityLatitude;
        } else {
            latitudeDifference = Math.abs(fromCityLatitude - toCityLatitude);
        }
        double A = ONE_DEGREE_LATITUDE * latitudeDifference;

        Double fromCityLongitude = Double.parseDouble(new StringBuilder(fromCity.getLongitude()).substring(0, 5));
        Double toCityLongitude = Double.parseDouble(new StringBuilder(toCity.getLongitude()).substring(0, 5));
        char longitudePlaceFromCity = new StringBuilder(fromCity.getLongitude()).charAt(5);
        char longitudePlaceToCity = new StringBuilder(toCity.getLongitude()).charAt(5);
        if (longitudePlaceFromCity != longitudePlaceToCity) {
            longitudeDifference = fromCityLongitude + toCityLongitude;
        } else {
            longitudeDifference = Math.abs(fromCityLongitude - toCityLongitude);
        }

        double B = longitudeDifference * ONE_DEGREE_LONGITUDE * Math.cos(Math.toRadians(Math.min(fromCityLatitude, toCityLatitude)));
        double distance = EARTH_RADIUS * Math.sqrt(Math.pow(A / EARTH_RADIUS, 2) + Math.pow(B / EARTH_RADIUS, 2));
        return new Distance(fromCity, toCity, distance);
    }


}
