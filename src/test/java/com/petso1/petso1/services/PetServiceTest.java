//package com.petso1.petso1.services;
//
//import com.petso1.petso1.entities.Pet;
//import com.petso1.petso1.exceptions.InvalidDataException;
//import com.petso1.petso1.exceptions.ResourceNotFoundException;
//import com.petso1.petso1.repositories.PetRepository;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.Optional;
//
//public class PetServiceTest {
//
//    @Mock
//    private PetRepository petRepository;
//
//    @InjectMocks
//    private PetServiceImpl petService;
//
//    public PetServiceTest() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCreatePet_Success() {
//        Pet pet = new Pet(null, "Buddy", "Dog", "Golden Retriever", 3);
//        when(petRepository.save(pet)).thenReturn(pet);
//
//        Pet createdPet = petService.createPet(pet);
//
//        assertNotNull(createdPet);
//        verify(petRepository, times(1)).save(pet);
//    }
//
//    @Test
//    void testCreatePet_InvalidData() {
//        Pet pet = new Pet(null, null, "Dog", "Golden Retriever", -1);
//
//        assertThrows(InvalidDataException.class, () -> petService.createPet(pet));
//    }
//
//    @Test
//    void testGetPetById_Found() {
//        Pet pet = new Pet(1L, "Buddy", "Dog", "Golden Retriever", 3);
//        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));
//
//        Pet foundPet = petService.getPetById(1L);
//
//        assertNotNull(foundPet);
//        assertEquals("Buddy", foundPet.getName());
//    }
//
//    @Test
//    void testGetPetById_NotFound() {
//        when(petRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(ResourceNotFoundException.class, () -> petService.getPetById(1L));
//    }
//
//    // Add more tests as needed
//}
