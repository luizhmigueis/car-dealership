package com.luizhmigueis.car_dealership.repositories;

import com.luizhmigueis.car_dealership.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarsRepository extends JpaRepository<Cars, UUID> {
}
