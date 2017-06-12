DROP TABLE IF EXISTS contact_hobby_detail;
DROP TABLE IF EXISTS contact_tel_detail;
DROP TABLE IF EXISTS hobby;
DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS contact_audit;
DROP SEQUENCE IF EXISTS contact_seq;
DROP SEQUENCE IF EXISTS contact_tel_detail_seq;
DROP SEQUENCE IF EXISTS contact_audit_seq;

CREATE SEQUENCE contact_seq START 1;
CREATE SEQUENCE contact_tel_detail_seq START 1;
CREATE SEQUENCE contact_audit_seq START 1;

CREATE TABLE contact (
	id         INT         NOT NULL PRIMARY KEY DEFAULT nextval('contact_seq'),
	first_name VARCHAR(60) NOT NULL,
	last_name  VARCHAR(40) NOT NULL,
	birth_date DATE,
	version    INT         NOT NULL             DEFAULT 0
);

CREATE UNIQUE INDEX uq_contact_1
	ON contact (first_name, last_name);

CREATE TABLE hobby (
	hobby_id VARCHAR(20) NOT NULL PRIMARY KEY
);

CREATE TABLE contact_tel_detail (
	id         INT         NOT NULL PRIMARY KEY DEFAULT nextval('contact_tel_detail_seq'),
	contact_id INT         NOT NULL,
	tel_type   VARCHAR(20) NOT NULL,
	tel_number VARCHAR(20) NOT NULL,
	version    INT         NOT NULL             DEFAULT 0,
	CONSTRAINT fk_contact_tel_detail_1 FOREIGN KEY (contact_id) REFERENCES contact (id)
);

CREATE UNIQUE INDEX uq_contact_tel_detail_1
	ON contact_tel_detail (contact_id, tel_type);

CREATE TABLE contact_hobby_detail (
	contact_id INT         NOT NULL,
	hobby_id   VARCHAR(20) NOT NULL,
	PRIMARY KEY (contact_id, hobby_id),
	CONSTRAINT fk_contact_hobby_detail_1 FOREIGN KEY (contact_id) REFERENCES contact (id) ON DELETE CASCADE,
	CONSTRAINT fk_contact_hobby_detail_2 FOREIGN KEY (hobby_id) REFERENCES hobby (hobby_id)
);

CREATE TABLE contact_audit (
	id                 INT         NOT NULL PRIMARY KEY DEFAULT nextval('contact_audit_seq'),
	first_name         VARCHAR(60) NOT NULL,
	last_name          VARCHAR(40) NOT NULL,
	birth_date         DATE,
	version            INT         NOT NULL             DEFAULT 0,
	created_by         VARCHAR(20),
	created_date       TIMESTAMP,
	last_modified_by    VARCHAR(20),
	last_modified_date TIMESTAMP
);

CREATE UNIQUE INDEX uq_contact_audit_1
	ON contact_audit (first_name, last_name);
