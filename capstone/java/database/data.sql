BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,is_provider)
	VALUES
('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', false);

INSERT INTO patient (user_id, first_name, last_name, phone_number, email_address, birthdate, health_issues_description)
	VALUES
		(100001, 'patientAFirst', 'patientALast', '800-555-1234', 'first.last@gmail.com', '1994-01-01', 'Insert health issues desc. here');

INSERT INTO users (username, password_hash, "role", is_provider)
	VALUES
	('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
	
INSERT INTO provider (user_id, title, first_name, last_name, post_nominals, specialty, gender, "language", rating, phone_number, bio, photo_URL)
	VALUES
		(100002, 'Dr.', 'providerAFirst', 'providerALast', 'MD', 'Pediatrics', 'Male', 'English', 4.55, '800-999-4567', 'Insert provider bio here.', 'https://as2.ftcdn.net/v2/jpg/03/20/52/31/1000_F_320523164_tx7Rdd7I2XDTvvKfz2oRuRpKOPE5z0ni.jpg');

INSERT INTO users (username, password_hash, "role", is_provider)
	VALUES
	('sally','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
	
INSERT INTO provider (user_id, title, first_name, last_name, post_nominals, specialty, gender, "language", rating, phone_number, bio, photo_URL)
	VALUES
		(100003, 'Dr.', 'Sally', 'Thomas', 'MD', 'Pediatric Physchiatry', 'Female', 'English', 4.55, '713-575-4231', 'A doctor who focuses on getting to know each child at their level and finding ways to build relationships to better their mental and emotional health.', 'https://images.squarespace-cdn.com/content/v1/53aa5722e4b0ada1a70119f2/1529694594561-7ERUUT9270RZI2R946J1/CORP20180521-Freeman+%284+of+6%29-Edit.jpg?format=1500w');
	
INSERT INTO users (username, password_hash, "role", is_provider)
	VALUES
	('derek','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
	
INSERT INTO provider (user_id, title, first_name, last_name, post_nominals, specialty, gender, "language", rating, phone_number, bio, photo_URL)
	VALUES
		(100004, 'Dr.', 'Derek', 'Thompson', 'MD', 'Family Practice', 'Male', 'English, Spanish, Chinese', 4.55, '832-736-2635', 'Family practioner that specializes in overall family medicine of all ages.', 'https://thumbs.dreamstime.com/b/portrait-positive-black-doctor-holding-medical-chart-male-over-white-background-178499631.jpg');

INSERT INTO users (username, password_hash, "role", is_provider)
	VALUES
	('pat','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
	
INSERT INTO provider (user_id, title, first_name, last_name, post_nominals, specialty, gender, "language", rating, phone_number, bio, photo_URL)
	VALUES
		(100005, 'Dr.', 'Pat', 'Kuhn', 'MD', 'Geriatrics', 'Female', 'English', 4.55, '806-874-2515', 'Medical doctor in community care, specializing in seniors.', 'https://t4.ftcdn.net/jpg/03/17/85/49/360_F_317854905_2idSdvi2ds3yejmk8mhvxYr1OpdVTrSM.jpg');

INSERT INTO users (username, password_hash, "role", is_provider)
	VALUES
	('barry','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);
	
INSERT INTO provider (user_id, title, first_name, last_name, post_nominals, specialty, gender, "language", rating, phone_number, bio, photo_URL)
	VALUES
		(100006, 'Mr.', 'Barry', 'Hartford', 'NP', 'Oncology', 'Male', 'English', 4.55, '806-681-1122', 'Nurse specialty of holistic colon cancer care planning and treatments.', 'https://cdn.create.vista.com/api/media/small/242085490/stock-photo-close-up-portrait-of-a');
		
INSERT INTO users (username, password_hash, "role", is_provider)
	VALUES
	('abel','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', true);	

INSERT INTO provider (user_id, title, first_name, last_name, post_nominals, specialty, gender, "language", rating, phone_number, bio, photo_URL)
	VALUES
		(100007, 'Dr.', 'Abel', 'Garcia', 'MD', 'Gastroenterologist', 'Male', 'English, Spanish, Arabic', 4.55, '832-886-6717', 'Specializing in colorectal surgery.', 'https://t3.ftcdn.net/jpg/02/97/95/66/360_F_297956690_OMymV1MsaWkAPYOeVVLsR6B5QD1jnp62.jpg');
		
INSERT INTO users (username,password_hash,role,is_provider)
	VALUES
('paul','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', false);

INSERT INTO patient (user_id, first_name, last_name, phone_number, email_address, birthdate, health_issues_description)
	VALUES
		(100008, 'Paul', 'Adams', '798-875-9935', 'paul.Adams@gmail.com', '1999-12-01', 'Asthma');
		
INSERT INTO users (username,password_hash,role,is_provider)
	VALUES
('rachel','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', false);

INSERT INTO patient (user_id, first_name, last_name, phone_number, email_address, birthdate, health_issues_description)
	VALUES
		(100009, 'Rachel', 'Berry', '798-568-7799', 'rachel.Berry@gmail.com', '1997-11-10', 'Depression');
		
INSERT INTO users (username,password_hash,role,is_provider)
	VALUES
('james','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', false);

INSERT INTO patient (user_id, first_name, last_name, phone_number, email_address, birthdate, health_issues_description)
	VALUES
		(100010, 'James', 'Ordway', '458-968-1122', 'james.Ordway@gmail.com', '1992-05-09', 'Arthritis');

INSERT INTO appointment (patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, appointment_reason, appointment_details, is_new_patient)
	VALUES (2001, 1001, '2022-10-31', '12:00:00', '12:30:00', 'Other', 'Referred by my primary care physician after my trip to the hospital last week.', true);
	
INSERT INTO appointment (patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, appointment_reason, appointment_details, is_new_patient)
	VALUES (2001, 1001, '2022-10-31', '09:00:00', '09:30:00', 'Other', 'Yearly checkup.', true);
	
INSERT INTO appointment (patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, appointment_reason, appointment_details, is_new_patient)
	VALUES (2002, 1001, '2022-10-31', '10:00:00', '10:30:00', 'Other', 'Yearly checkup.', false);
	
INSERT INTO appointment (patient_id, provider_id, appointment_date, appt_start_time, appt_end_time, appointment_reason, appointment_details, is_new_patient)
	VALUES (2003, 1001, '2022-10-31', '11:00:00', '11:30:00', 'Other', 'Yearly checkup.', true);

INSERT INTO office (office_name, tag_line, street_address, city, "state", zipcode, office_open_time, office_close_time, phone_number, cost_per_hour, "message")
	VALUES
	('Memorial Hermann Physician Group', 'Quality Care, Quality Health', '1011 Washington St', 'Chicago', 'IL', 60018, '09:00:00', '17:00:00', '888-979-4545', 20.00, 'Insert Website Alert Message Here.');

INSERT INTO review (office_id, patient_id, provider_id, review_text, review_date, review_time, provider_rating, provider_response_text, response_date, response_time)
	VALUES
		(1, 2001, 1001, 'Patient provides review text here.', '2022-09-27', '10:30:00', 5, 'Provider provides review response text here.', '2022-09-28', '13:45:00');

INSERT INTO review (office_id, patient_id, provider_id, review_text, review_date, review_time, provider_rating, provider_response_text, response_date, response_time)
	VALUES
		(1, 2002, 1002, 'Good Doctor.', '2022-09-30', '10:30:00', 4, 'Provider provides review response text here.', '2022-09-28', '13:45:00');

INSERT INTO review (office_id, patient_id, provider_id, review_text, review_date, review_time, provider_rating, provider_response_text, response_date, response_time)
	VALUES
		(1, 2002, 1003, 'Arrived late to my appointment.', '2022-10-01', '10:30:00', 2, 'Provider provides review response text here.', '2022-09-28', '13:45:00');

INSERT INTO review (office_id, patient_id, provider_id, review_text, review_date, review_time, provider_rating, provider_response_text, response_date, response_time)
	VALUES
		(1, 2001, 1004, 'Great care!', '2022-09-29', '10:30:00', 5, 'Provider provides review response text here.', '2022-09-28', '13:45:00');
		
INSERT INTO review (office_id, patient_id, provider_id, review_text, review_date, review_time, provider_rating, provider_response_text, response_date, response_time)
	VALUES
		(1, 2003, 1005, 'Would recommend to anyone!', '2022-09-30', '10:30:00', 5, 'Provider provides review response text here.', '2022-09-28', '13:45:00');
		
INSERT INTO review (office_id, patient_id, provider_id, review_text, review_date, review_time, provider_rating, provider_response_text, response_date, response_time)
	VALUES
		(1, 2003, 1006, 'Barely spoke to me.', '2022-09-30', '10:30:00', 2, 'Provider provides review response text here.', '2022-09-28', '13:45:00');
		
INSERT INTO provider_office (provider_id, office_id)
	VALUES (1001, 1);
INSERT INTO provider_office (provider_id, office_id)
	VALUES (1002, 1);
INSERT INTO provider_office (provider_id, office_id)
	VALUES (1003, 1);
INSERT INTO provider_office (provider_id, office_id)
	VALUES (1004, 1);
INSERT INTO provider_office (provider_id, office_id)
	VALUES (1005, 1);
INSERT INTO provider_office (provider_id, office_id)
	VALUES (1006, 1);

COMMIT TRANSACTION;