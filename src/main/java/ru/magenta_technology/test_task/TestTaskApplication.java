package ru.magenta_technology.test_task;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.magenta_technology.test_task.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(FileStorageProperties.class)
public class TestTaskApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestTaskApplication.class, args);
    }

}
