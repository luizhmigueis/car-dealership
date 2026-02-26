package com.luizhmigueis.car_dealership.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String carLicensePlate;
    private String brand;
    private String model;
    private Integer yearModel;
    private String color;
    private Double kilometers;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private Owner owner;
}
