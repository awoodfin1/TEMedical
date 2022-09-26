BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS patient CASCADE;
DROP TABLE IF EXISTS provider CASCADE;
DROP TABLE IF EXISTS office CASCADE;
DROP TABLE IF EXISTS provider_office CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS responses CASCADE;
DROP TABLE IF EXISTS appointments CASCADE;

DROP SEQUENCE IF EXISTS user_serial;
DROP SEQUENCE IF EXISTS patient_serial;
DROP SEQUENCE IF EXISTS provider_serial;
DROP SEQUENCE IF EXISTS appointment_serial;
DROP SEQUENCE IF EXISTS office_serial;
DROP SEQUENCE IF EXISTS review_serial;
DROP SEQUENCE IF EXISTS response_serial;

CREATE SEQUENCE user_serial;
CREATE TABLE users (
	user_id int NOT NULL default nextval ('user_serial'),
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,

	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE patient_serial;
CREATE TABLE patient (
             patient_id int NOT NULL default nextval ('patient_serial'),
             user_id int,
             first_name varchar(20),
             last_name varchar(30),

             CONSTRAINT pk_patient PRIMARY KEY (patient_id),
             CONSTRAINT fk_patient FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE SEQUENCE provider_serial;
CREATE TABLE provider (
             provider_id int NOT NULL default nextval ('provider_serial'),
             user_id int,
             first_name varchar(20),
             last_name varchar(30),
             title varchar(15),

             CONSTRAINT pk_provider PRIMARY KEY (provider_id),
             CONSTRAINT fk_provider FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE SEQUENCE office_serial;
CREATE TABLE office (
             office_id int NOT NULL default nextval ('office_serial'),
             street_address varchar(50),
             city varchar(40),
             state char(2),
             zipcode int,
             office_open_time TIME,
             office_close_time TIME,
             phone_number varchar(10),
             cost_per_hour NUMERIC(4,2),
             has_appt_delay boolean,

             CONSTRAINT pk_office PRIMARY KEY (office_id)
);

CREATE TABLE provider_office (
             provider_id int NOT NULL,
             office_id int NOT NULL,

			 CONSTRAINT pk_provider_office PRIMARY KEY(provider_id, office_id),
             CONSTRAINT fk_provider_office_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id),
             CONSTRAINT fk_provider_office_office_id FOREIGN KEY (office_id) REFERENCES office(office_id)
);

CREATE SEQUENCE review_serial;
CREATE TABLE reviews (
             review_id int NOT NULL default nextval ('review_serial'),
             office_id int,
             patient_id int,
             review_text varchar(500),
             review_time TIMESTAMP,
             rating int,

             CONSTRAINT pk_reviews PRIMARY KEY (review_id),
             CONSTRAINT fk_reviews_office_id FOREIGN KEY (office_id) REFERENCES office(office_id),
             CONSTRAINT fk_reviews_patient_id FOREIGN KEY (patient_id) REFERENCES patient(patient_id)
);

CREATE SEQUENCE response_serial;
CREATE TABLE responses (
             response_id int NOT NULL default nextval ('response_serial'),
             review_id int,
             provider_id int,
             response_text varchar(500),
             response_time TIMESTAMP,

             CONSTRAINT pk_responses PRIMARY KEY (response_id),
             CONSTRAINT fk_responses_review_id FOREIGN KEY (review_id) REFERENCES reviews(review_id),
             CONSTRAINT fk_responses_provider_id FOREIGN KEY (provider_id) REFERENCES provider_office(provider_id)
);

CREATE SEQUENCE appointment_serial;
CREATE TABLE appointments (
             appointment_id int NOT NULL default nextval ('appointment_serial'),
             patient_id int,
             provider_id int,
             appointment_date DATE,
             appt_start_time TIME,
             appt_end_time TIME,
             status varchar(3),
             appointment_reason varchar(70),
             appointment_details varchar(100),

             CONSTRAINT pk_appointments PRIMARY KEY (appointment_id),
             CONSTRAINT fk_appointments_patient_id FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
             CONSTRAINT fk_appointments_provider_id FOREIGN KEY (provider_id) REFERENCES provider(provider_id)
);


--INSERT INTO users (user_id, username, password_hash, role) VALUES (0, 'user1', 'pass1', patient);

--INSERT INTO patient (patient_id, user_id, balance) VALUES (2002, 1002, 1000);


COMMIT TRANSACTION;

