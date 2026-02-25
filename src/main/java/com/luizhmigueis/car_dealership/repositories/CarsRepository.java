package com.luizhmigueis.car_dealership.repositories;

import com.luizhmigueis.car_dealership.entities.Cars;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CarsRepository extends JpaRepository<Cars, Long> {

    Optional<Cars> findByCarLicensePlate(String carLicensePlate);

    @Transactional
    void deleteByCarLicensePlate(String carLicensePlate);
}
