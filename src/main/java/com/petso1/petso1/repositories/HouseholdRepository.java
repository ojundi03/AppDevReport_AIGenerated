package com.petso1.petso1.repositories;

import com.petso1.petso1.entities.Household;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface HouseholdRepository extends JpaRepository<Household, String> {

    @Query("SELECT h FROM Household h LEFT JOIN FETCH h.pets WHERE h.eircode = :eircode")
    Household findByEircodeWithPets(@Param("eircode") String eircode);

    // Method to find households with no pets
    @Query("SELECT h FROM Household h WHERE h.pets IS EMPTY")
    List<Household> findHouseholdsWithNoPets();

    @EntityGraph(attributePaths = {"pets"})
    Optional<Household> findByEircode(String eircode);

    List<Household> findByOwnerOccupiedTrue();

    // 10. Get Household Statistics
    @Query("SELECT COUNT(h) FROM Household h WHERE h.numberOfOccupants = 0")
    Long countEmptyHouses();

    @Query("SELECT COUNT(h) FROM Household h WHERE h.numberOfOccupants = h.maxNumberOfOccupants")
    Long countFullHouses();
}

