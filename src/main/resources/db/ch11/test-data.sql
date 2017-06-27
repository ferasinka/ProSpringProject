DELETE FROM car;
ALTER SEQUENCE car_seq RESTART WITH 1;

INSERT INTO car (license_plate, manufacturer, manufacture_date) VALUES ('LICENSE-1001', 'Ford', '1980-07-30');
INSERT INTO car (license_plate, manufacturer, manufacture_date) VALUES ('LICENSE-1002', 'Toyota', '1992-12-30');
INSERT INTO car (license_plate, manufacturer, manufacture_date) VALUES ('LICENSE-1003', 'BMW', '2003-1-6');
