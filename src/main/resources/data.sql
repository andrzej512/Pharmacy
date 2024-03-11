INSERT INTO pharmacies(name) VALUES ('DrMax');
INSERT INTO pharmacies(name) VALUES ('DOZ');
INSERT INTO medicines(name, medicine_form) VALUES ('APAP', 'TABLET');
INSERT INTO medicines(name, medicine_form) VALUES ('VIT', 'INJECTION');
INSERT INTO medicines(name, medicine_form) VALUES ('SYROP', 'LIQUID');
INSERT INTO pharmacy_branch_address(country, city, street) VALUES ('Poland', 'Warsaw', 'Mickiewicza 5');
INSERT INTO pharmacy_branch_address(country, city, street) VALUES ('Poland', 'Wroclaw', 'Swobodna');
INSERT INTO pharmacy_branch_address(country, city, street) VALUES ('Poland', 'Wroclaw', 'Wielka');
INSERT INTO pharmacy_branch_address(country, city, street) VALUES ('UK', 'London', 'Downtown');
INSERT INTO pharmacy_branch(pharmacy_id, pharmacy_branch_address_id) VALUES (1,1);
INSERT INTO pharmacy_branch(pharmacy_id, pharmacy_branch_address_id) VALUES (1,2);
INSERT INTO pharmacy_branch(pharmacy_id,pharmacy_branch_address_id) VALUES (2,3);
INSERT INTO pharmacy_branch(pharmacy_id,pharmacy_branch_address_id) VALUES ( 1,4 );
INSERT INTO stock(on_stock, medicine_id, pharmacy_branch_id) VALUES (12, 1, 1);
INSERT INTO stock(on_stock, medicine_id, pharmacy_branch_id) VALUES (10, 1, 2);
INSERT INTO stock(on_stock, medicine_id, pharmacy_branch_id) VALUES (6, 2, 2);


