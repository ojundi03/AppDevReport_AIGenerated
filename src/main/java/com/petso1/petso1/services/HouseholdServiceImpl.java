package com.petso1.petso1.services;


import com.petso1.petso1.entities.Household;
import com.petso1.petso1.exceptions.InvalidDataException;
import com.petso1.petso1.exceptions.ResourceNotFoundException;
import com.petso1.petso1.repositories.HouseholdRepository;
import com.petso1.petso1.services.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HouseholdServiceImpl implements HouseholdService {

    private final HouseholdRepository householdRepository;

    @Autowired
    public HouseholdServiceImpl(HouseholdRepository householdRepository) {
        this.householdRepository = householdRepository;
    }

    @Override
    public Household createHousehold(Household household) {
        // Validate household data
        if (household.getEircode() == null || household.getEircode().isBlank()) {
            throw new InvalidDataException("Eircode cannot be null or empty.");
        }
        if (household.getNumberOfOccupants() < 0 || household.getMaxNumberOfOccupants() <= 0) {
            throw new InvalidDataException("Occupant numbers must be positive.");
        }
        if (household.getNumberOfOccupants() > household.getMaxNumberOfOccupants()) {
            throw new InvalidDataException("Number of occupants cannot exceed maximum number of occupants.");
        }
        // Check if household already exists
        if (householdRepository.existsById(household.getEircode())) {
            throw new InvalidDataException("Household with this eircode already exists.");
        }
        return householdRepository.save(household);
    }


    @Override
    public Household getHouseholdByEircode(String eircode) {
        return householdRepository.findById(eircode)
                .orElseThrow(() -> new ResourceNotFoundException("Household not found with eircode " + eircode));
    }

    @Override
    public List<Household> getAllHouseholds() {
        return householdRepository.findAll();
    }

    @Override
    public Household updateHousehold(String eircode, Household householdDetails) {
        Household household = getHouseholdByEircode(eircode);

        // Validate data
        if (householdDetails.getNumberOfOccupants() < 0 || householdDetails.getMaxNumberOfOccupants() <= 0) {
            throw new InvalidDataException("Occupant numbers must be positive.");
        }
        if (householdDetails.getNumberOfOccupants() > householdDetails.getMaxNumberOfOccupants()) {
            throw new InvalidDataException("Number of occupants cannot exceed maximum number of occupants.");
        }

        household.setNumberOfOccupants(householdDetails.getNumberOfOccupants());
        household.setMaxNumberOfOccupants(householdDetails.getMaxNumberOfOccupants());
        household.setOwnerOccupied(householdDetails.isOwnerOccupied());

        return householdRepository.save(household);
    }

    @Override
    public void deleteHouseholdByEircode(String eircode) {
        Household household = getHouseholdByEircode(eircode);
        householdRepository.delete(household);
    }

    @Override
    public Household getHouseholdByEircodeWithPets(String eircode) {
        return householdRepository.findByEircode(eircode)
                .orElseThrow(() -> new ResourceNotFoundException("Household not found with eircode " + eircode));
    }

    // 2. Find List of Households with No Pets
    @Override
    public List<Household> getHouseholdsWithNoPets() {
        return householdRepository.findHouseholdsWithNoPets();
    }

    @Override
    public List<Household> getOwnerOccupiedHouseholds() {
        return householdRepository.findByOwnerOccupiedTrue();
    }
    @Override
    public Long getNumberOfEmptyHouses() {
        return householdRepository.countEmptyHouses();
    }

    @Override
    public Long getNumberOfFullHouses() {
        return householdRepository.countFullHouses();
    }

}
