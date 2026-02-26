package com.luizhmigueis.car_dealership.services;

import com.luizhmigueis.car_dealership.entities.Owner;
import com.luizhmigueis.car_dealership.repositories.OwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OwnersService {

    @Autowired
    private OwnersRepository ownersRepository;

    public Owner findById(Long id) {
        return ownersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

    }
    public void saveOwner(Owner owner){
        ownersRepository.saveAndFlush(owner);
    }

    @Transactional(readOnly = true) // <--- Adicione isso aqui
    public List<Owner> findAll(){
        List<Owner> list = ownersRepository.findAll();
        // Opcional: Forçar o carregamento tocando na lista
        list.forEach(owner -> owner.getCar().size());
        return list;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Owner findByDriversLicense(Long driversLicense){
        Owner owner = ownersRepository.findByDriversLicense(driversLicense).orElseThrow(
                () -> new RuntimeException("Driver license not found")
        );
        owner.getCar().size(); // Força o carregamento dos carros
        return owner;
    }
    public void deleteByDriversLicense (Long driversLicense){
        ownersRepository.deleteByDriversLicense(driversLicense);
    }
    public void updateOwnerByDriversLicense (Long driversLicense, Owner owner){
        Owner ownerEntity = ownersRepository.findByDriversLicense(driversLicense).orElseThrow(() -> new RuntimeException("Id não encontrado"));
        Owner ownerUpdated = Owner.builder()
                .id(ownerEntity.getId())
                .name(owner.getName() != null ? owner.getName() : ownerEntity.getName())
                .driversLicense(owner.getDriversLicense() != null ? owner.getDriversLicense() : ownerEntity.getDriversLicense())
                .build();

        ownersRepository.saveAndFlush(ownerUpdated);
    }
}
