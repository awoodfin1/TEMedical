BEGIN TRANSACTION;

INSERT INTO users (user_id,username,password_hash,role,is_provider)
	VALUES
(100001,'user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', false);

INSERT INTO patient (patient_id, user_id, first_name, last_name, phone_number, email_address, birthdate, health_issues_description)
	VALUES
		(2001, 100001, 'patientAFirst', 'patientALast', '8005551234', 'first.last@gmail.com', '1994-01-01', 'Insert health issues desc. here');

INSERT INTO users (user_id,username,password_hash,role, is_provider)
	VALUES
	(100002,'admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
	
INSERT INTO provider (provider_id, user_id, title, first_name, last_name, post_nominals, gender, language, rating, phone_number, bio, photo_URL)
	VALUES
		(1001, 100002, 'Dr.', 'providerAFirst', 'providerALast', 'MD', 'Male', 'English', 4.55, '8009994567', 'Insert provider bio here.', 'https://as2.ftcdn.net/v2/jpg/03/20/52/31/1000_F_320523164_tx7Rdd7I2XDTvvKfz2oRuRpKOPE5z0ni.jpg');

INSERT INTO appointment (patient_id, provider_id, appointment_date, appt_start_time, appt_end_time)
	VALUES (2001, 1001, '2022-10-31', '12:00:00', '12:30:00');

INSERT INTO office (office_id, office_name, tag_line, street_address, city, "state", zipcode, office_open_time, office_close_time, phone_number, cost_per_hour, has_appt_delay)
	VALUES
	(1, 'Memorial Hermann Physician Group', 'Quality Care, Quality Health', '1011 Washington St', 'Chicago', 'IL', 60018, '09:00:00', '17:00:00','8889794545',20.00, false);

INSERT INTO specialty (field_name)
	VALUES ('Oncology');

INSERT INTO review (office_id, patient_id, provider_id, review_text, review_date, review_time, provider_rating, provider_response_text, response_date, response_time)
	VALUES
		(1, 2001, 1001, 'Patient provides review text here.', '2022-09-27', '10:30:00', 5, 'Provider provides review response text here.', '2022-09-28', '13:45:00');

INSERT INTO provider_office (provider_id, office_id)
	VALUES (1001, 1);

INSERT INTO provider_specialty (provider_id, specialty_id)
	VALUES (1001, 101);

COMMIT TRANSACTION;
