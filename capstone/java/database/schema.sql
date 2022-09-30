BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, patient, provider, appointment, office, review, specialty, provider_office, provider_specialty CASCADE;

DROP SEQUENCE IF EXISTS user_serial, patient_serial, provider_serial, appointment_serial, office_serial, review_serial, specialty_serial CASCADE;

-- Sequence to start user_id values at 100,001 instead of 1
CREATE SEQUENCE user_serial
  INCREMENT BY 1
  START WITH 100001
  NO MAXVALUE;
  
CREATE TABLE users (
	user_id int NOT NULL default nextval ('user_serial'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	"role" varchar(50) NOT NULL,
	is_provider boolean,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- Sequence to start patient_id values at 2,001 instead of 1
CREATE SEQUENCE patient_serial
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE;
  
CREATE TABLE patient (
    patient_id int NOT NULL default nextval ('patient_serial'),
    user_id int,
    first_name varchar(30) NOT NULL,
	last_name varchar(40) NOT NULL,
	phone_number varchar(10),
	email_address varchar(60),
	birthdate date,
	health_issues_description varchar(500),

    CONSTRAINT pk_patient PRIMARY KEY (patient_id),
	CONSTRAINT fk_patient FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Sequence to start patient_id values at 1,001 instead of 1
CREATE SEQUENCE provider_serial
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;
  
CREATE TABLE provider (
	provider_id int NOT NULL default nextval ('provider_serial'),
	user_id int,
	title varchar(4),
    first_name varchar(30),
    last_name varchar(40),
	post_nominals varchar(20),
	gender varchar(6),
	"language" varchar(15),
	rating numeric(4,2),
	phone_number varchar(10),
	bio varchar(500),
	photo_URL varchar(200),	
    
    CONSTRAINT pk_provider PRIMARY KEY (provider_id),
    CONSTRAINT fk_provider FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Sequence to start appointment_id values at 1001 instead of 1
CREATE SEQUENCE appointment_serial
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;
  
CREATE TABLE appointment (
	appointment_id int NOT NULL default nextval ('appointment_serial'),
    patient_id int NOT NULL,
    provider_id int NOT NULL,
    appointment_date DATE NOT NULL,
    appt_start_time TIME NOT NULL,
    appt_end_time TIME,
    status varchar(15) DEFAULT ('Confirmed'),
    appointment_reason varchar(70),
    appointment_details varchar(100),

    CONSTRAINT pk_appointment PRIMARY KEY (appointment_id),
    CONSTRAINT fk_appointment_patient_id FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
    CONSTRAINT fk_appointment_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id)
);

-- Sequence to start office_id values at 1
CREATE SEQUENCE office_serial
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;
  
CREATE TABLE office (
    office_id int NOT NULL default nextval ('office_serial'),
	office_name varchar (75) NOT NULL,
	tag_line varchar (100),
    street_address varchar(50),
    city varchar(40),
    "state" char(2),
    zipcode int,
    office_open_time time,
    office_close_time time,
    phone_number varchar(10),
    cost_per_hour numeric(4,2),
    has_appt_delay boolean NOT NULL default (false),

    CONSTRAINT pk_office PRIMARY KEY (office_id)
);

-- Sequence to start review_id values at 1,001 instead of 1
CREATE SEQUENCE review_serial
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE review (
	review_id int NOT NULL default nextval ('review_serial'),
    office_id int,
    patient_id int,
	provider_id int,
    review_text varchar(500),
	review_date date,
    review_time time,
    provider_rating int,
	provider_response_text varchar(500),
	response_date date,
	response_time time,

    CONSTRAINT pk_review PRIMARY KEY (review_id),
    CONSTRAINT fk_review_office_id FOREIGN KEY (office_id) REFERENCES office(office_id),
    CONSTRAINT fk_review_patient_id FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
	CONSTRAINT fk_review_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id)
);

-- Sequence to start specialty_id values at 101 instead of 1
CREATE SEQUENCE specialty_serial
  INCREMENT BY 1
  START WITH 101
  NO MAXVALUE;
  
CREATE TABLE specialty (
	specialty_id int default nextval ('specialty_serial'),
	field_name varchar(60),
	
	CONSTRAINT PK_specialty PRIMARY KEY (specialty_id)
);

CREATE TABLE provider_office (
	provider_id int NOT NULL UNIQUE,
    office_id int NOT NULL,

	CONSTRAINT pk_provider_office PRIMARY KEY(provider_id, office_id),
    CONSTRAINT fk_provider_office_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id),
    CONSTRAINT fk_provider_office_office_id FOREIGN KEY (office_id) REFERENCES office(office_id)
);

CREATE TABLE provider_specialty (
	provider_id int NOT NULL UNIQUE,
	specialty_id int NOT NULL,
	
	CONSTRAINT PK_provider_specialty PRIMARY KEY(provider_id, specialty_id),
	CONSTRAINT FK_provider_specialty_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id),
	CONSTRAINT FK_provider_specialty_specialty_id FOREIGN KEY (specialty_id) REFERENCES specialty(specialty_id)
);


COMMIT TRANSACTION;