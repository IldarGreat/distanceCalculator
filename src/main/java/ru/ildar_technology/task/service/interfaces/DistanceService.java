package ru.ildar_technology.task.service.interfaces;

import org.springframework.web.multipart.MultipartFile;
import ru.ildar_technology.task.model.domain.Distance;

import java.util.List;

public interface DistanceService {
    void saveAll(MultipartFile file);

    void saveAll(List<Distance> distances);
}
