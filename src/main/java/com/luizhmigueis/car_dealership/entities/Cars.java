package com.luizhmigueis.car_dealership.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="cars")
public class Cars {

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
    @JoinColumn(name = "owners_id")
    @JsonBackReference
    private Owners owners;





}
