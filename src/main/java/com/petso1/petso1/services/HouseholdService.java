package com.petso1.petso1.services;

import com.petso1.petso1.entities.Household;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseholdService {
    Household createHousehold(Household household);
    Household getHouseholdByEircode(String eircode);
    List<Household> getAllHouseholds();
    Household updateHousehold(String eircode, Household household);
    void deleteHouseholdByEircode(String eircode);
    Household getHouseholdByEircodeWithPets(String eircode);
    List<Household> getHouseholdsWithNoPets();
    List<Household> getOwnerOccupiedHouseholds();
    Long getNumberOfEmptyHouses();
    Long getNumberOfFullHouses();


}
