DROP TABLE IF EXISTS car;
DROP SEQUENCE IF EXISTS car_seq;

CREATE SEQUENCE car_seq START 1;

CREATE TABLE car (
	id               INT         NOT NULL PRIMARY KEY DEFAULT nextval('car_seq'),
	license_plate    VARCHAR(20) NOT NULL,
	manufacturer     VARCHAR(20) NOT NULL,
	manufacture_date DATE        NOT NULL,
	age              INT         NOT NULL             DEFAULT 0,
	version          INT         NOT NULL             DEFAULT 0
);

CREATE UNIQUE INDEX uq_car_1
	ON car (license_plate);
