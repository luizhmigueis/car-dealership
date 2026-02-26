package com.luizhmigueis.car_dealership.controllers;

import com.luizhmigueis.car_dealership.entities.Cars;
import com.luizhmigueis.car_dealership.entities.Owners;
import com.luizhmigueis.car_dealership.repositories.OwnersRepository;
import com.luizhmigueis.car_dealership.services.OwnersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnersController {

    private final OwnersService ownersService;
    private final OwnersRepository ownersRepository;


    @PostMapping
    public ResponseEntity<Void> saveOwner(@RequestBody Owners owner){
        ownersService.saveOwner(owner);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Owners> findByDriversLicense(@RequestParam Long driversLicense){

        return ResponseEntity.ok(ownersService.findByDriversLicense(driversLicense));
    }
    @GetMapping("/allowners")
    public Page<Owners> getOwners(Pageable pageable){
        List<Owners> list = ownersService.findAll();
        return ownersRepository.findAll(pageable);
    }


    //Parei aqui, trocando os cars, Cars para Owners owners



    @DeleteMapping
    public ResponseEntity<Void> deleteByDriversLicense(@RequestParam Long driversLicense){
        ownersService.deleteByDriversLicense(driversLicense);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> updateOwnerByDriversLicense(@RequestParam Long driversLicense, @RequestBody Owners owner){
        ownersService.updateOwnerByDriversLicense(driversLicense, owner);
        return ResponseEntity.ok().build();
    }

}


