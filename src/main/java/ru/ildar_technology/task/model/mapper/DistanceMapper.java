package ru.ildar_technology.task.model.mapper;

import org.mapstruct.Mapper;
import ru.ildar_technology.task.model.domain.Distance;
import ru.ildar_technology.task.model.dto.DistanceDto;

@Mapper(componentModel = "spring")
public interface DistanceMapper {

    DistanceDto toDto(Distance distance);
}
