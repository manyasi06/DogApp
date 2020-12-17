DROP TABLE IF EXISTS dogs;


CREATE TABLE dogs (
	id INT AUTO_INCREMENT PRIMARY KEY,
	breed VARCHAR(250),
	nameofdog VARCHAR(250),
	ownerfirstname VARCHAR(250),
	ownerlastname VARCHAR(250)
);

INSERT INTO dogs (breed, nameofdog,ownerfirstname,ownerlastname) VALUES
('labrodoodle','John','Frank','Gore'),
('doodle','Leo','Fred','Benson'),
('poodle','Bryan','Bob','Dole');