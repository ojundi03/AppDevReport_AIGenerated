-- Data insertion for household
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied) VALUES ('D01F5P2', 3, 5, TRUE);
INSERT INTO household (eircode, number_of_occupants, max_number_of_occupants, owner_occupied) VALUES ('D02G6Q3', 2, 4, FALSE);

-- Data insertion for pets with household_eircode
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Buddy', 'Dog', 'Golden Retriever', 3, 'D01F5P2');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Mittens', 'Cat', 'Siamese', 2, 'D01F5P2');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Charlie', 'Dog', 'Beagle', 4, 'D02G6Q3');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Whiskers', 'Cat', 'Persian', 5, 'D02G6Q3');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Coco', 'Rabbit', 'Holland Lop', 1, 'D01F5P2');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Goldie', 'Fish', 'Goldfish', 1, 'D01F5P2');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Polly', 'Bird', 'Parakeet', 2, 'D02G6Q3');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Max', 'Dog', 'German Shepherd', 5, 'D01F5P2');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Luna', 'Cat', 'Maine Coon', 3, 'D02G6Q3');
INSERT INTO pets (name, animal_type, breed, age, household_eircode) VALUES ('Nibbles', 'Hamster', 'Syrian Hamster', 1, 'D01F5P2');
