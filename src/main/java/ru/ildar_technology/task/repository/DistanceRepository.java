package ru.ildar_technology.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ildar_technology.task.model.domain.City;
import ru.ildar_technology.task.model.domain.Distance;

import java.util.Optional;

@Repository
public interface DistanceRepository extends JpaRepository<Distance, Long> {
    Optional<Distance> findByFromCityAndToCity(City fromCity, City toCity);
}
