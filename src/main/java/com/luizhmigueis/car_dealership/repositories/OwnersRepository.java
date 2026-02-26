package com.luizhmigueis.car_dealership.repositories;

import com.luizhmigueis.car_dealership.entities.Owner;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnersRepository extends JpaRepository<Owner,Long> {
    Optional<Owner> findByDriversLicense(Long driversLicense);

    @Transactional
    void deleteByDriversLicense(Long driversLicense);
}
