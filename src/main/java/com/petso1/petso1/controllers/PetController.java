package com.petso1.petso1.controllers;

import com.petso1.petso1.dto.ChangePetNameRequest;
import com.petso1.petso1.entities.Pet;
import com.petso1.petso1.services.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
@Validated
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    /**
     * Get all pets - Accessible to anyone
     * GET /api/pets
     */
    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        List<Pet> pets = petService.getAllPets();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    /**
     * Get a specific pet by ID - Accessible to anyone
     * GET /api/pets/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        Pet pet = petService.getPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    /**
     * Create a new pet - Accessible to ADMIN only
     * POST /api/pets
     */
    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Pet> createPet(@Valid @RequestBody Pet pet) {
        Pet createdPet = petService.createPet(pet);
        return new ResponseEntity<>(createdPet, HttpStatus.CREATED);
    }

    /**
     * Delete a pet by ID - Accessible to ADMIN only
     * DELETE /api/pets/{id}
     */
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Change a pet's name - Accessible to ADMIN and USER
     * PATCH /api/pets/{id}/name
     */
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PatchMapping("/{id}/name")
    public ResponseEntity<Pet> changePetName(@PathVariable Long id,
                                             @Valid @RequestBody ChangePetNameRequest nameRequest) {
        Pet updatedPet = petService.changePetName(id, nameRequest.getName());
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }
}