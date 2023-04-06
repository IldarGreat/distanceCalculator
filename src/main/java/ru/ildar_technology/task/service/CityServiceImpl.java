package ru.ildar_technology.task.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ildar_technology.task.model.domain.City;
import ru.ildar_technology.task.model.dto.CityDto;
import ru.ildar_technology.task.model.mapper.CityMapper;
import ru.ildar_technology.task.repository.CityRepository;
import ru.ildar_technology.task.service.interfaces.CityService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    @Override
    public List<CityDto> getCities() {
        List<City> cities = cityRepository.findAll();
        return cityMapper.toDtos(cities);
    }
}
