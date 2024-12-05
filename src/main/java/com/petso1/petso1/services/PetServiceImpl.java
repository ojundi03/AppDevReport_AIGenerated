package com.petso1.petso1.services;

import com.petso1.petso1.entities.Pet;
import com.petso1.petso1.exceptions.InvalidDataException;
import com.petso1.petso1.exceptions.ResourceNotFoundException;
import com.petso1.petso1.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    // 1. Create Pet
    @Override
    public Pet createPet(Pet pet) {
        if (pet.getName() == null || pet.getAnimalType() == null || pet.getBreed() == null || pet.getAge() <= 0) {
            throw new InvalidDataException("Invalid pet data provided.");
        }
        return petRepository.save(pet);
    }

    // 2. Read All Pets
    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    // 3. Read Pet by ID
    @Override
    public Pet getPetById(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pet not found with id " + id));
    }

    // 4. Update Pet Details
    @Override
    public Pet updatePet(Long id, Pet petDetails) {
        Pet pet = getPetById(id);

        if (petDetails.getName() == null || petDetails.getAnimalType() == null || petDetails.getBreed() == null || petDetails.getAge() <= 0) {
            throw new InvalidDataException("Invalid pet data provided.");
        }

        pet.setName(petDetails.getName());
        pet.setAnimalType(petDetails.getAnimalType());
        pet.setBreed(petDetails.getBreed());
        pet.setAge(petDetails.getAge());

        return petRepository.save(pet);
    }

    // 5. Delete Pet by ID
    @Override
    public void deletePetById(Long id) {
        if (!petRepository.existsById(id)) {
            throw new ResourceNotFoundException("Pet not found with id " + id);
        }
        petRepository.deleteById(id);
    }

    // 6. Delete Pets by Name (Ignoring Case)
    @Override
    public void deletePetsByName(String name) {
        petRepository.deleteByNameIgnoreCase(name);
    }

    // 7. Find Pets by Animal Type
    @Override
    public List<Pet> getPetsByAnimalType(String animalType) {
        return petRepository.findByAnimalTypeIgnoreCase(animalType);
    }

    // 8. Find Pets by Breed, Ordered by Age
    @Override
    public List<Pet> getPetsByBreedOrderedByAge(String breed) {
        return petRepository.findByBreedIgnoreCaseOrderByAge(breed);
    }

    // 9. Get Name and Breed Only
    @Override
    public List<Pet> getNameAnimalTypeAndBreed() {
        return petRepository.findNameAnimalTypeAndBreed();
    }

    // 10. Get Pet Statistics (Average Age, Oldest Age)
    @Override
    public Double getAverageAge() {
        return petRepository.findAverageAge();
    }

    @Override
    public Integer getOldestAge() {
        return petRepository.findMaxAge();
    }
}
