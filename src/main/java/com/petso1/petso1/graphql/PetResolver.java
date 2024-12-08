package com.petso1.petso1.graphql;

import com.petso1.petso1.entities.Household;
import com.petso1.petso1.entities.Pet;
import com.petso1.petso1.services.HouseholdService;
import com.petso1.petso1.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

@Component
public class PetResolver {

    private final PetService petService;
    private final HouseholdService householdService;

    @Autowired
    public PetResolver(PetService petService, HouseholdService householdService) {
        this.petService = petService;
        this.householdService = householdService;
    }

    // Example Mutation with ID as String
    @MutationMapping
    public Pet createPet(@Argument("input") PetInput input) {
        Pet pet = new Pet();
        pet.setName(input.getName());
        pet.setAnimalType(input.getAnimalType());
        pet.setBreed(input.getBreed());
        pet.setAge(input.getAge());

        if (input.getHouseholdId() != null) {
            String eircode = input.getHouseholdId();
            Household household = householdService.getHouseholdByEircode(eircode);
            pet.setHousehold(household);
        }

        return petService.createPet(pet);
    }

    // Similar conversion can be applied in other resolver methods
}