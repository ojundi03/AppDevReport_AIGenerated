package com.petso1.petso1.dto;


import jakarta.validation.constraints.NotBlank;

public class ChangePetNameRequest {

    @NotBlank(message = "Pet name cannot be blank")
    private String name;

    // Constructors
    public ChangePetNameRequest() {
    }

    public ChangePetNameRequest(String name) {
        this.name = name;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
