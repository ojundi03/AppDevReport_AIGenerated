package com.petso1.petso1.controllers;

import com.petso1.petso1.entities.Household;
import com.petso1.petso1.entities.Pet;
import com.petso1.petso1.entities.Statistics;
import com.petso1.petso1.services.HouseholdService;
import com.petso1.petso1.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLController {

    private final HouseholdService householdService;
    private final PetService petService;

    @Autowired
    public GraphQLController(HouseholdService householdService, PetService petService) {
        this.householdService = householdService;
        this.petService = petService;
    }

    // 1. Get all households
    @QueryMapping
    public List<Household> allHouseholds() {
        return householdService.getAllHouseholds();
    }

    // 2. Get all pets by animal type
    @QueryMapping
    public List<Pet> petsByAnimalType(String animalType) {
        return petService.getPetsByAnimalType(animalType);
    }

    // 3. Get a household by eircode
    @QueryMapping
    public Household household(String eircode) {
        return householdService.getHouseholdByEircodeWithPets(eircode);
    }

    // 4. Get a pet by ID
    @QueryMapping
    public Pet pet(Long id) {
        return petService.getPetById(id);
    }

    // 5. Get statistics
    @QueryMapping
    public Statistics statistics() {
        Statistics stats = new Statistics();
        stats.setAveragePetAge(petService.getAverageAge());
        stats.setOldestPetAge(petService.getOldestAge().intValue());
        stats.setEmptyHouseholds(householdService.getNumberOfEmptyHouses().intValue());
        stats.setFullHouseholds(householdService.getNumberOfFullHouses().intValue());
        return stats;
    }

    // Mutation: Create a new household
    @MutationMapping
    public Household createHousehold(@Argument("input") HouseholdInput input) {
        Household household = new Household();
        household.setEircode(input.getEircode());
        household.setNumberOfOccupants(input.getNumberOfOccupants());
        household.setMaxNumberOfOccupants(input.getMaxNumberOfOccupants());
        household.setOwnerOccupied(input.isOwnerOccupied());

        return householdService.createHousehold(household);
    }

    // Mutation: Delete a household by eircode
    @MutationMapping
    public Boolean deleteHousehold(@Argument String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return true;
    }

    // Mutation: Delete a pet by ID
    @MutationMapping
    public Boolean deletePet(@Argument Long id) {
        petService.deletePetById(id);
        return true;
    }
}
