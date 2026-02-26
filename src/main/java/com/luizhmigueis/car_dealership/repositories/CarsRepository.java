package com.luizhmigueis.car_dealership.repositories;

import com.luizhmigueis.car_dealership.entities.Car;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarsRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByCarLicensePlate(String carLicensePlate);

    @Transactional
    void deleteByCarLicensePlate(String carLicensePlate);

    @Query("SELECT c FROM Car c JOIN FETCH c.owner")
    List<Car> findCarsByOwners();
}
