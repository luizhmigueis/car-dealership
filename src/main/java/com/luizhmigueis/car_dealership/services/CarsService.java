package com.luizhmigueis.car_dealership.services;


import com.luizhmigueis.car_dealership.entities.Cars;
import com.luizhmigueis.car_dealership.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    private CarsRepository repository;

    public void saveCar(Cars car){
        repository.saveAndFlush(car);
    }
    public List<Cars> findAll(){
        return repository.findAll();
    }

    public Cars findByPlate(String carLicensePlate){
        return repository.findByCarLicensePlate(carLicensePlate).orElseThrow(
                () -> new RuntimeException("Car license plate not found")
        );
    }
    public void deleteCarByCarLicensePlate (String carLicensePlate){
        repository.deleteByCarLicensePlate(carLicensePlate);
    }
    public void updateCarById (Long id, Cars car){
        Cars carEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Id não encontrado"));
        Cars carUpdated = Cars.builder()
                .id(carEntity.getId())
                .carLicensePlate(car.getCarLicensePlate() != null ? car.getCarLicensePlate() : carEntity.getCarLicensePlate())
                .brand(car.getBrand() != null ? car.getBrand() : carEntity.getBrand())
                .model(car.getModel() != null ? car.getModel() : carEntity.getModel())
                .yearModel(car.getYearModel() != null ? car.getYearModel() : carEntity.getYearModel())
                .color(car.getColor() != null ? car.getColor() : carEntity.getColor())
                .kilometers(car.getKilometers() != null ? car.getKilometers() : carEntity.getKilometers())
                .build();

        repository.saveAndFlush(carUpdated);
    }

}
