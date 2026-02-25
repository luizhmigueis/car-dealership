package com.luizhmigueis.car_dealership.controllers;


import com.luizhmigueis.car_dealership.entities.Cars;
import com.luizhmigueis.car_dealership.repositories.CarsRepository;
import com.luizhmigueis.car_dealership.services.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarsController {

    private final CarsService carsService;
    private final CarsRepository carsRepository;

    @PostMapping
    public ResponseEntity<Void> saveCar(@RequestBody Cars car){
        carsService.saveCar(car);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Cars> findByPlate(@RequestParam String carLicensePlate){

        return ResponseEntity.ok(carsService.findByPlate(carLicensePlate));
    }
    @GetMapping("/allcars")
    public Page<Cars> getCars(Pageable pageable){
        List<Cars> list = carsService.findAll();
        return carsRepository.findAll(pageable);
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteCarByCarLicensePlate(@RequestParam String carLicensePlate){
        carsService.deleteCarByCarLicensePlate(carLicensePlate);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> updateCarById(@RequestParam Long id, @RequestBody Cars car){
        carsService.updateCarById(id, car);
        return ResponseEntity.ok().build();
    }

}
