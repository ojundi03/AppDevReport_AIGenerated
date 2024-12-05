package com.petso1.petso1.repositories;

import com.petso1.petso1.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    // 6. Delete Pets by Name (Ignoring Case)
    void deleteByNameIgnoreCase(String name);

    // 7. Find Pets by Animal Type
    List<Pet> findByAnimalTypeIgnoreCase(String animalType);

    // 8. Find Pets by Breed, Ordered by Age
    List<Pet> findByBreedIgnoreCaseOrderByAge(String breed);

    // 9. Get Name and Breed Only
    @Query("SELECT new com.petso1.petso1.entities.Pet(p.name, p.animalType, p.breed) FROM Pet p")
    List<Pet> findNameAnimalTypeAndBreed();

    // 10. Get Pet Statistics (Average Age, Oldest Age)
    @Query("SELECT AVG(p.age) FROM Pet p")
    Double findAverageAge();

    @Query("SELECT MAX(p.age) FROM Pet p")
    Integer findMaxAge();


}
