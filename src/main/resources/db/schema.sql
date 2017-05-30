DROP TABLE IF EXISTS contact_tel_detail;
DROP TABLE IF EXISTS contact;
DROP SEQUENCE IF EXISTS contact_seq;
DROP SEQUENCE IF EXISTS contact_tel_detail_seq;

CREATE SEQUENCE contact_seq START 1;
CREATE SEQUENCE contact_tel_detail_seq START 1;

CREATE TABLE contact (
	id         INT         NOT NULL PRIMARY KEY DEFAULT nextval('contact_seq'),
	first_name VARCHAR(60) NOT NULL,
	last_name  VARCHAR(40) NOT NULL,
	birth_date DATE
);

CREATE UNIQUE INDEX uq_contact_1
	ON contact (first_name, last_name);

CREATE TABLE contact_tel_detail (
	id         INT         NOT NULL PRIMARY KEY DEFAULT nextval('contact_tel_detail_seq'),
	contact_id INT         NOT NULL,
	tel_type   VARCHAR(20) NOT NULL,
	tel_number VARCHAR(20) NOT NULL,
	CONSTRAINT fk_contact_tel_detail_1 FOREIGN KEY (contact_id) REFERENCES contact (id)
);

CREATE UNIQUE INDEX uq_contact_tel_detail_1
	ON contact_tel_detail (contact_id, tel_type);
