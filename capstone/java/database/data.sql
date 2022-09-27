BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('user2', 'password_hash', 'ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin2', 'password_hash', 'ROLE_ADMIN');

INSERT INTO patient (user_id, first_name, last_name) VALUES (1, 'testFirstA', 'testLastA');
INSERT INTO patient (user_id, first_name, last_name) VALUES (2, 'first', 'last');

INSERT INTO provider (user_id, first_name, last_name, title) VALUES (3, 'testFirstB', 'testLastB', 'M.D.');
INSERT INTO provider (user_id, first_name, last_name, title) VALUES (4, 'firstProvider', 'lastProvider', 'D.O.');

INSERT INTO appointments (patient_id, provider_id, appointment_date, appt_start_time, appt_end_time) VALUES (1, 3, '2022-10-31', '09:00:00', '09:30:00');

COMMIT TRANSACTION;
