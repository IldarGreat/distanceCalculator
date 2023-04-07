package ru.ildar_technology.task.model.mapper;

import org.mapstruct.Mapper;
import ru.ildar_technology.task.model.domain.City;
import ru.ildar_technology.task.model.dto.CityDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    List<CityDto> toDtos(List<City> cities);
}
