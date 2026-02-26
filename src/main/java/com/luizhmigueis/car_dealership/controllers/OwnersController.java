package com.luizhmigueis.car_dealership.controllers;

import com.luizhmigueis.car_dealership.entities.Owner;
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
    public ResponseEntity<Void> saveOwner(@RequestBody Owner owner){
        ownersService.saveOwner(owner);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Owner> findByDriversLicense(@RequestParam Long driversLicense){

        return ResponseEntity.ok(ownersService.findByDriversLicense(driversLicense));
    }
    @GetMapping("/with-cars")
    public ResponseEntity<List<Owner>> getAllWithCars() {
        List<Owner> owners = ownersService.findAll();
        return ResponseEntity.ok(owners);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByDriversLicense(@RequestParam Long driversLicense){
        ownersService.deleteByDriversLicense(driversLicense);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> updateOwnerByDriversLicense(@RequestParam Long driversLicense, @RequestBody Owner owner){
        ownersService.updateOwnerByDriversLicense(driversLicense, owner);
        return ResponseEntity.ok().build();
    }

}


