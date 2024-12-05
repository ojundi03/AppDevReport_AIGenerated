package com.petso1.petso1.controllers;

import com.petso1.petso1.entities.Household;
import com.petso1.petso1.entities.Pet;
import com.petso1.petso1.services.HouseholdService;
import com.petso1.petso1.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;
    private final HouseholdService householdService;

    @Autowired
    public PetController(PetService petService, HouseholdService householdService) {
        this.petService = petService;
        this.householdService = householdService;
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        // Validate and set the household
        String eircode = pet.getHousehold().getEircode();
        Household household = householdService.getHouseholdByEircode(eircode);
        pet.setHousehold(household);

        return petService.createPet(pet);
    }
    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deletePetsByName(@PathVariable String name) {
        petService.deletePetsByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
