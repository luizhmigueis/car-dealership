package com.luizhmigueis.car_dealership.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Owners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private Long driversLicense;

    @OneToMany(mappedBy = "owners")
    @JsonManagedReference
    private List<Cars> cars;

}
