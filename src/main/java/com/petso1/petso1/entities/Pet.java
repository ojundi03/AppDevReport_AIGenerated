package com.petso1.petso1.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "animal_type")
    private String animalType;

    private String breed;

    private int age;

    @ManyToOne(optional = false)
    @JoinColumn(name = "household_eircode", nullable = false)
    private Household household;

}
