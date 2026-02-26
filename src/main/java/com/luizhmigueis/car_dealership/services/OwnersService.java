package com.luizhmigueis.car_dealership.services;

import com.luizhmigueis.car_dealership.entities.Cars;
import com.luizhmigueis.car_dealership.entities.Owners;
import com.luizhmigueis.car_dealership.repositories.OwnersRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnersService {

    @Autowired
    private OwnersRepository ownersRepository;

    public Owners findById(Long id) {
        return ownersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

    }
    public void saveOwner(Owners owner){
        ownersRepository.saveAndFlush(owner);
    }
    public List<Owners> findAll(){
        return ownersRepository.findAll();
    }

    public Owners findByDriversLicense(Long driversLicense){
        return ownersRepository.findByDriversLicense(driversLicense).orElseThrow(
                () -> new RuntimeException("Driver license not found")
        );
    }
    public void deleteByDriversLicense (Long driversLicense){
        ownersRepository.deleteByDriversLicense(driversLicense);
    }
    public void updateOwnerByDriversLicense (Long driversLicense, Owners owner){
        Owners ownerEntity = ownersRepository.findByDriversLicense(driversLicense).orElseThrow(() -> new RuntimeException("Id não encontrado"));
        Owners ownerUpdated = Owners.builder()
                .id(ownerEntity.getId())
                .name(owner.getName() != null ? owner.getName() : ownerEntity.getName())
                .driversLicense(owner.getDriversLicense() != null ? owner.getDriversLicense() : ownerEntity.getDriversLicense())
                .build();

        ownersRepository.saveAndFlush(ownerUpdated);
    }
}
