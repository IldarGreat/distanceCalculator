package ru.ildar_technology.task.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record CityDto(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
                      @NotBlank(message = "Name is mandatory") @Size(max = 255) String name,
                      @NotBlank(message = "Latitude is mandatory") @Size(max = 6) String latitude,
                      @NotBlank(message = "Longitude is mandatory") @Size(max = 6) String longitude) {
}
