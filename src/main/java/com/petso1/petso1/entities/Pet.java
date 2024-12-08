package com.petso1.petso1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pets")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
//
//    // Constructor with all fields
//    public Pet() {
//
//
//    }

    public Pet(String name, String animalType, String Breed){
        this.name = name;
        this.animalType = animalType;
        this.breed = Breed;
    }


//
//    // Getter and Setter for id
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    // Getter and Setter for name
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    // Getter and Setter for animalType
//    public String getAnimalType() {
//        return animalType;
//    }
//
//    public void setAnimalType(String animalType) {
//        this.animalType = animalType;
//    }
//
//    // Getter and Setter for breed
//    public String getBreed() {
//        return breed;
//    }
//
//    public void setBreed(String breed) {
//        this.breed = breed;
//    }
//
//    // Getter and Setter for age
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    // Getter and Setter for household
//    public Household getHousehold() {
//        return household;
//    }
//
//    public void setHousehold(Household household) {
//        this.household = household;
//    }
}