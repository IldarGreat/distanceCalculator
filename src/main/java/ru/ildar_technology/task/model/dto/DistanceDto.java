package ru.ildar_technology.task.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record DistanceDto(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                          @NotNull CityDto fromCity,
                          @NotNull CityDto toCity,
                          @NotEmpty double distance) {
}
