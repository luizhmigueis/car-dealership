package com.luizhmigueis.car_dealership.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name="cars")
public class Cars {

    @Id
    private UUID id;
    private String brand;
    private String model;
    private Integer yearModel;
    private String color;


}
