package com.petso1.petso1.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "household")
public class Household {

    @Id
    @Column(length = 8)
    private String eircode;

    @Column(name = "number_of_occupants", nullable = false)
    private int numberOfOccupants;

    @Column(name = "max_number_of_occupants", nullable = false)
    private int maxNumberOfOccupants;

    @Column(name = "owner_occupied", nullable = false)
    private boolean ownerOccupied;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pet> pets = new ArrayList<>();

    // Getter and Setter for eircode
    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    // Getter and Setter for numberOfOccupants
    public int getNumberOfOccupants() {
        return numberOfOccupants;
    }

    public void setNumberOfOccupants(int numberOfOccupants) {
        this.numberOfOccupants = numberOfOccupants;
    }

    // Getter and Setter for maxNumberOfOccupants
    public int getMaxNumberOfOccupants() {
        return maxNumberOfOccupants;
    }

    public void setMaxNumberOfOccupants(int maxNumberOfOccupants) {
        this.maxNumberOfOccupants = maxNumberOfOccupants;
    }

    // Getter and Setter for ownerOccupied
    public boolean isOwnerOccupied() {
        return ownerOccupied;
    }

    public void setOwnerOccupied(boolean ownerOccupied) {
        this.ownerOccupied = ownerOccupied;
    }

    // Getter and Setter for pets
    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
