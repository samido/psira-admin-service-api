-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- CREATE SCHEMA IF NOT EXISTS psira_admin_database;

USE psira_admin_database;

CREATE TABLE posts (
   post_id INT AUTO_INCREMENT PRIMARY KEY,
   post_name VARCHAR(255) NOT NULL,
   job_description TEXT NOT NULL,
   business_unit ENUM('ICT', 'Human Capital', 'Law Enforcement', 'Finance') NOT NULL,
   manager_id INT,
   experience_years INT NOT NULL CHECK (experience_years >= 0 AND experience_years <= 10),
   qualification ENUM('Diploma', 'Degree', 'Honors', 'Masters', 'PhD') NOT NULL,
   drivers_license_required BOOLEAN NOT NULL,
   opening_date DATE NOT NULL,
   closing_date DATE NOT NULL
);

INSERT INTO posts (post_name, job_description, business_unit, manager_id, experience_years, qualification, drivers_license_required, opening_date, closing_date) VALUES
 ('Software Developer', 'Responsible for developing and maintaining software applications.', 'ICT', 1, 3, 'Degree', true, '2024-01-01', '2024-01-31'),
 ('Human Resources Manager', 'Oversee HR functions including recruitment and employee relations.', 'Human Capital', 2, 5, 'Masters', false, '2024-02-01', '2024-02-28'),
 ('Financial Analyst', 'Analyze financial data and provide insights to the management team.', 'Finance', 3, 2, 'Honors', true, '2024-03-01', '2024-03-31');
 ('Software Developer', 'Responsible for developing and maintaining software applications.', 'ICT', 1, 3, 'Degree', true, '2024-01-01', '2024-01-31'),
 ('Human Resources Manager', 'Oversee HR functions including recruitment and employee relations.', 'Human Capital', 2, 5, 'Masters', false, '2024-02-01', '2024-02-28'),
 ('Financial Analyst', 'Analyze financial data and provide insights to the management team.', 'Finance', 3, 2, 'Honors', true, '2024-03-01', '2024-03-31');
