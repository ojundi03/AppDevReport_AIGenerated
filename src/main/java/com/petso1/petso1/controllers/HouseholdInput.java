package com.petso1.petso1.controllers;

import lombok.Data;

@Data
public class HouseholdInput {
    private String eircode;
    private int numberOfOccupants;
    private int maxNumberOfOccupants;
    private boolean ownerOccupied;
}
