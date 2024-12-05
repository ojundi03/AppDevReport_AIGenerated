package com.petso1.petso1.controllers;

import com.petso1.petso1.entities.Household;
import com.petso1.petso1.exceptions.ResourceNotFoundException;
import com.petso1.petso1.repositories.HouseholdRepository;
import com.petso1.petso1.services.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    private final HouseholdService householdService;
    private final HouseholdRepository householdRepository;

    @Autowired
    public HouseholdController(HouseholdService householdService, HouseholdRepository householdRepository) {
        this.householdService = householdService;
        this.householdRepository = householdRepository;
    }

    @PostMapping
    public ResponseEntity<Household> createHousehold(@RequestBody Household household) {
        Household createdHousehold = householdService.createHousehold(household);
        return new ResponseEntity<>(createdHousehold, HttpStatus.CREATED);
    }

    // 3. Read Household by ID - Excluding Pets
    public Household getHouseholdByEircode(String eircode) {
        return householdRepository.findById(eircode)
                .orElseThrow(() -> new ResourceNotFoundException("Household not found with eircode " + eircode));
    }
    @GetMapping("/{eircode}/with-pets")
    public ResponseEntity<Household> getHouseholdByEircodeWithPets(@PathVariable String eircode) {
        Household household = householdService.getHouseholdByEircodeWithPets(eircode);
        return new ResponseEntity<>(household, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Household>> getAllHouseholds() {
        List<Household> households = householdService.getAllHouseholds();
        return new ResponseEntity<>(households, HttpStatus.OK);
    }

    @PutMapping("/{eircode}")
    public ResponseEntity<Household> updateHousehold(@PathVariable String eircode, @RequestBody Household householdDetails) {
        Household updatedHousehold = householdService.updateHousehold(eircode, householdDetails);
        return new ResponseEntity<>(updatedHousehold, HttpStatus.OK);
    }

    @DeleteMapping("/{eircode}")
    public ResponseEntity<?> deleteHousehold(@PathVariable String eircode) {
        householdService.deleteHouseholdByEircode(eircode);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/no-pets")
    public ResponseEntity<List<Household>> getHouseholdsWithNoPets() {
        List<Household> households = householdService.getHouseholdsWithNoPets();
        return new ResponseEntity<>(households, HttpStatus.OK);
    }
    @GetMapping("/owner-occupied")
    public ResponseEntity<List<Household>> getOwnerOccupiedHouseholds() {
        List<Household> households = householdService.getOwnerOccupiedHouseholds();
        return new ResponseEntity<>(households, HttpStatus.OK);
    }

    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Long>> getHouseholdStatistics() {
        Long emptyHouses = householdService.getNumberOfEmptyHouses();
        Long fullHouses = householdService.getNumberOfFullHouses();

        Map<String, Long> statistics = new HashMap<>();
        statistics.put("emptyHouses", emptyHouses);
        statistics.put("fullHouses", fullHouses);

        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }

}
