package com.petso1.petso1.controllers;
import com.petso1.petso1.entities.Household;
import com.petso1.petso1.entities.Pet;
import com.petso1.petso1.entities.Statistics;
import com.petso1.petso1.services.HouseholdService;
import com.petso1.petso1.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.security.access.annotation.Secured;
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
    // Queries accessible by all users
    @QueryMapping
    public List<Household> allHouseholds() {
        return householdService.getAllHouseholds();
    }
    @QueryMapping
    public List<Pet> petsByAnimalType(String animalType) {
        return petService.getPetsByAnimalType(animalType);
    }
    @QueryMapping
    public Household household(String eircode) {
        return householdService.getHouseholdByEircodeWithPets(eircode);
    }
    @QueryMapping
    public Pet pet(Long id) {
        return petService.getPetById(id);
    }
    @QueryMapping
    public Statistics statistics() {
        Statistics stats = new Statistics();
        stats.setAveragePetAge(petService.getAverageAge());
        stats.setOldestPetAge(petService.getOldestAge().intValue());
        stats.setEmptyHouseholds(householdService.getNumberOfEmptyHouses().intValue());
        stats.setFullHouseholds(householdService.getNumberOfFullHouses().intValue());
        return stats;
    }
    // Mutations requiring authentication
// Create a new household (accessible to authenticated users with ROLE_USER)
    @MutationMapping
    @Secured("ROLE_USER")
    public Household createHousehold(@Argument("input") HouseholdInput input) {
        Household household = new Household();
        household.setEircode(input.getEircode());
        household.setNumberOfOccupants(input.getNumberOfOccupants());
        household.setMaxNumberOfOccupants(input.getMaxNumberOfOccupants());
        household.setOwnerOccupied(input.isOwnerOccupied());
        return householdService.createHousehold(household);
    }
    // Delete a household by eircode (accessible to users with ROLE_ADMIN)
    @MutationMapping
    @Secured("ROLE_ADMIN")
    public Boolean deleteHousehold(@Argument String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return true;
    }
    // Delete a pet by ID (accessible to users with ROLE_ADMIN)
    @MutationMapping
    @Secured("ROLE_ADMIN")
    public Boolean deletePet(@Argument Long id) {
        petService.deletePetById(id);
        return true;
    }
}