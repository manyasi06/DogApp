DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS persons;

CREATE TABLE persons (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`firstname` VARCHAR(25),
	`lastname` VARCHAR(25)
);

CREATE TABLE dogs (
	`id` INT AUTO_INCREMENT PRIMARY KEY,
	`breed` VARCHAR(250),
	`nameofdog` VARCHAR(250),
	`person_id` INT NOT NULL,
	CONSTRAINT `items_ibfk_1` FOREIGN KEY(`person_id`) REFERENCES persons(`id`) ON DELETE CASCADE
);

INSERT INTO persons (firstname, lastname) VALUES
('Bryan', 'Musungu'),('Erin', 'Greenwalt'),
('Frank', 'Louis'),
('Grace', 'Chavis');


INSERT INTO dogs (breed, nameofdog, person_id) VALUES
('labrodoodle','John',1),
('doodle','Leo',1),
('berndoodle','Frank',2),
('pyredoodle','Jake',3),
('poodle','Bryan',2),
('poodle','Jcole',3);



