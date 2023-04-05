package ru.ildar_technology.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.ildar_technology.task.exception.custom.FileStorageException;
import ru.ildar_technology.task.property.FileStorageProperties;

import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;

@Service
public class FileStorageService {
    private final Path fileStorageLocation;
    private static String fileName;

    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public Boolean storeFile(MultipartFile file) throws IOException {
        fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Path targetLocation = this.fileStorageLocation.resolve(fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return true;
    }

    public static String getFileName() {
        return fileName;
    }
}
