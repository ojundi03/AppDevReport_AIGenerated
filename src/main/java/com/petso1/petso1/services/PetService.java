package com.petso1.petso1.services;

import com.petso1.petso1.entities.Pet;
import java.util.List;

public interface PetService {

    // 1. Create Pet
    Pet createPet(Pet pet);

    // 2. Read All Pets
    List<Pet> getAllPets();

    // 3. Read Pet by ID
    Pet getPetById(Long id);

    // 4. Update Pet Details
    Pet updatePet(Long id, Pet pet);

    // 5. Delete Pet by ID
    void deletePetById(Long id);

    // 6. Delete Pets by Name (Ignoring Case)
    void deletePetsByName(String name);

    // 7. Find Pets by Animal Type
    List<Pet> getPetsByAnimalType(String animalType);

    // 8. Find Pets by Breed, Ordered by Age
    List<Pet> getPetsByBreedOrderedByAge(String breed);

    // 9. Get Name and Breed Only
    List<Pet> getNameAnimalTypeAndBreed();

    // 10. Get Pet Statistics (Average Age, Oldest Age)
    Double getAverageAge();
    Integer getOldestAge();

    Pet changePetName(Long id, String newName);
}
