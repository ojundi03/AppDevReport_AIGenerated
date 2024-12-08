package com.petso1.petso1.graphql;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PetInput {

    @NotBlank(message = "Pet name cannot be blank")
    private String name;

    @NotBlank(message = "Animal type cannot be blank")
    private String animalType;

    @NotBlank(message = "Breed cannot be blank")
    private String breed;

    @Min(value = 0, message = "Age cannot be negative")
    private int age;

    private String householdId; // Changed from Long to String

    // Getters and Setters

    public PetInput() {
    }

    public PetInput(String name, String animalType, String breed, int age, String householdId) {
        this.name = name;
        this.animalType = animalType;
        this.breed = breed;
        this.age = age;
        this.householdId = householdId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(String householdId) {
        this.householdId = householdId;
    }
}
