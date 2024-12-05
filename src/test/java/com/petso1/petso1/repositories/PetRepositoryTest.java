//package com.petso1.petso1.repositories;
//
//import com.petso1.petso1.entities.Household;
//import com.petso1.petso1.entities.Pet;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.when;
//
//@DataJpaTest
//public class PetRepositoryTest {
//
//    @Autowired
//    private PetRepository petRepository;
//
//    @BeforeEach
//    void setUp() {
//        petRepository.save(new Pet(null, "Buddy", "Dog", "Golden Retriever", 3));
//        petRepository.save(new Pet(null, "Mittens", "Cat", "Siamese", 2));
//    }
//
//    @Test
//    void testFindByAnimalTypeIgnoreCase() {
//        List<Pet> pets = petRepository.findByAnimalTypeIgnoreCase("dog");
//        assertEquals(1, pets.size());
//        assertEquals("Buddy", pets.get(0).getName());
//    }
//
//    @Test
//    void testDeleteByNameIgnoreCase() {
//        petRepository.deleteByNameIgnoreCase("mittens");
//        List<Pet> pets = petRepository.findAll();
//        assertEquals(1, pets.size());
//        assertEquals("Buddy", pets.get(0).getName());
//    }
//
//    // Add more tests as needed
////    @Test
////    void testCreatePet_Success() {
////        Household household = new Household("D01F5P2", 3, 5, true, new ArrayList<>());
////        Pet pet = new Pet(null, "Buddy", "Dog", "Golden Retriever", 3, household);
////
////        SimpleJpaRepository<T, String> householdRepository;
////        when(householdRepository.findById("D01F5P2")).thenReturn(Optional.of(household));
////        when(petRepository.save(pet)).thenReturn(pet);
////
////        Pet createdPet = petService.createPet(pet);
////
////        assertNotNull(createdPet);
////        assertEquals("D01F5P2", createdPet.getHousehold().getEircode());
////        verify(petRepository, times(1)).save(pet);
////    }
//}
