package com.petso1.petso1.controllers;

import com.petso1.petso1.entities.Household;
import com.petso1.petso1.services.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
@Validated
public class HouseholdController {

    private final HouseholdService householdService;

    @Autowired
    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    /**
     * Get all households - Accessible to anyone
     * GET /api/households
     */
    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        List<Household> households = householdService.getAllHouseholds();
        return new ResponseEntity<>(households, HttpStatus.OK);
    }

    /**
     * Get households with no pets - Accessible to anyone
     * GET /api/households/no-pets
     */
    @GetMapping("/no-pets")
    public ResponseEntity<List<Household>> getHouseholdsWithNoPets() {
        List<Household> households = householdService.getHouseholdsWithNoPets();
        return new ResponseEntity<>(households, HttpStatus.OK);
    }

    /**
     * Get a specific household by Eircode - Accessible to anyone
     * GET /api/households/{eircode}
     */
    @GetMapping("/{eircode}")
    public ResponseEntity<Household> getHouseholdByEircode(@PathVariable String eircode) {
        Household household = householdService.getHouseholdByEircode(eircode);
        return new ResponseEntity<>(household, HttpStatus.OK);
    }

    /**
     * Create a new household - Accessible to ADMIN only
     * POST /api/households
     */
    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Household> createHousehold(@Valid @RequestBody Household household) {
        Household createdHousehold = householdService.createHousehold(household);
        return new ResponseEntity<>(createdHousehold, HttpStatus.CREATED);
    }

    /**
     * Delete a household by Eircode - Accessible to ADMIN only
     * DELETE /api/households/{eircode}
     */
    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{eircode}")
    public ResponseEntity<Void> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
