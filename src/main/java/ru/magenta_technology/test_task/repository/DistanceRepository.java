package ru.magenta_technology.test_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.magenta_technology.test_task.domain.*;

import java.util.Optional;

@Repository
public interface DistanceRepository extends JpaRepository<Distance, Long> {
    Optional<Distance> findByFromCityAndToCity(City fromCity, City toCity);
}
