package ru.ildar_technology.task.exception.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JsonExceptionMessage {
    private String info;
}
