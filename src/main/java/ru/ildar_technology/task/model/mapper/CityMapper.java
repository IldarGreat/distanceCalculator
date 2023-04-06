package ru.ildar_technology.task.model.mapper;

import org.mapstruct.Mapper;
import ru.ildar_technology.task.model.domain.City;
import ru.ildar_technology.task.model.dto.CityDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City toEntity(CityDto cityDto);

    CityDto toDto(City city);

    List<CityDto> toDtos(List<City> cities);
}
