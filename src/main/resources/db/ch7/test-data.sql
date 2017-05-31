DELETE FROM contact_hobby_detail;
DELETE FROM contact_tel_detail;
DELETE FROM hobby;
DELETE FROM contact;
ALTER SEQUENCE contact_seq RESTART WITH 1;
ALTER SEQUENCE contact_tel_detail_seq RESTART WITH 1;

INSERT INTO contact (first_name, last_name, birth_date) VALUES ('Chris', 'Schaefer', '1981-05-03');
INSERT INTO contact (first_name, last_name, birth_date) VALUES ('Scott', 'Tiger', '1990-11-02');
INSERT INTO contact (first_name, last_name, birth_date) VALUES ('John', 'Smith', '1964-02-28');

INSERT INTO contact_tel_detail (contact_id, tel_type, tel_number) VALUES (1, 'Mobile', '1234567890');
INSERT INTO contact_tel_detail (contact_id, tel_type, tel_number) VALUES (1, 'Home', '1234567890');
INSERT INTO contact_tel_detail (contact_id, tel_type, tel_number) VALUES (2, 'Home', '1234567890');

INSERT INTO hobby (hobby_id) VALUES ('Swimming');
INSERT INTO hobby (hobby_id) VALUES ('Jogging');
INSERT INTO hobby (hobby_id) VALUES ('Programming');
INSERT INTO hobby (hobby_id) VALUES ('Movies');
INSERT INTO hobby (hobby_id) VALUES ('Reading');

INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (1, 'Swimming');
INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (1, 'Movies');
INSERT INTO contact_hobby_detail (contact_id, hobby_id) VALUES (2, 'Swimming');
