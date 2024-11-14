-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- CREATE SCHEMA IF NOT EXISTS psira_admin_database;

USE psira_admin_database;

CREATE TABLE managers (
  manager_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  surname VARCHAR(100) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  tell VARCHAR(15),
  position VARCHAR(100)
);

-- Create the posts table
CREATE TABLE posts (
   post_id INT AUTO_INCREMENT PRIMARY KEY,
   post_name VARCHAR(255) NOT NULL,
   job_description TEXT NOT NULL,
   business_unit ENUM('ICT', 'HUMAN_CAPITAL', 'LAW_ENFORCEMENT', 'FINANCE') NOT NULL,
   manager_id INT NOT NULL,
   experience_years INT NOT NULL CHECK (experience_years >= 0 AND experience_years <= 10),
   qualification ENUM('DIPLOMA', 'DEGREE', 'HONORS', 'MASTERS', 'PHD') NOT NULL,
   drivers_license_required BOOLEAN NOT NULL,
   opening_date DATE NOT NULL,
   closing_date DATE NOT NULL,
   CONSTRAINT fk_manager FOREIGN KEY (manager_id) REFERENCES managers(manager_id)
);