INSERT INTO pharmacies(name) VALUES ('PharmacyTest1');
INSERT INTO pharmacies(name) VALUES ('PharmacyTest2');
INSERT INTO medicines(name, medicine_form) VALUES ('APAP', 'TABLET');
INSERT INTO medicines(name, medicine_form) VALUES ('VIT', 'INJECTION');
INSERT INTO medicines(name, medicine_form) VALUES ('SYROP', 'LIQUID');
INSERT INTO pharmacy_branch_address(country, city, street) VALUES ('testCountry', 'testCity', 'testStreet');
INSERT INTO pharmacy_branch_address(country, city, street) VALUES ('testCountry2', 'testCity2', 'testStreet2');
INSERT INTO pharmacy_branch(pharmacy_id, pharmacy_branch_address_id) VALUES (1,1);
INSERT INTO pharmacy_branch(pharmacy_id, pharmacy_branch_address_id) VALUES (1,2);