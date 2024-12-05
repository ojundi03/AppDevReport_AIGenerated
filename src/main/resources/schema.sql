-- Existing table creation for household (ensure this is before pets table due to FK constraint)
CREATE TABLE household (
                           eircode VARCHAR(8) PRIMARY KEY,
                           number_of_occupants INT NOT NULL,
                           max_number_of_occupants INT NOT NULL,
                           owner_occupied BOOLEAN NOT NULL
);

-- Modify pets table to include household_eircode as a foreign key
CREATE TABLE pets (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL,
                      animal_type VARCHAR(255) NOT NULL,
                      breed VARCHAR(255) NOT NULL,
                      age INT NOT NULL,
                      household_eircode VARCHAR(8) NOT NULL,
                      CONSTRAINT fk_household
                          FOREIGN KEY (household_eircode)
                              REFERENCES household(eircode)
                              ON DELETE CASCADE
);

-- Create the 'users' table
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       locked BOOLEAN NOT NULL,
                       first_name VARCHAR(100) NOT NULL,
                       last_name VARCHAR(100) NOT NULL,
                       county VARCHAR(50) NOT NULL
);