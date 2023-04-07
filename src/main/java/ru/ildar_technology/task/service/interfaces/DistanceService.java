package ru.ildar_technology.task.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

public interface DistanceService {
    void saveAll(MultipartFile file);

}
