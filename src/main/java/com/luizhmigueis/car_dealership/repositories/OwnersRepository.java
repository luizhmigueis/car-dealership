package com.luizhmigueis.car_dealership.repositories;

import com.luizhmigueis.car_dealership.entities.Cars;
import com.luizhmigueis.car_dealership.entities.Owners;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnersRepository extends JpaRepository<Owners,Long> {
    Optional<Owners> findByDriversLicense(Long driversLicense);

    @Transactional
    void deleteByDriversLicense(Long driversLicense);
}
