BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS patient CASCADE;
DROP TABLE IF EXISTS provider CASCADE;
DROP TABLE IF EXISTS office CASCADE;
DROP TABLE IF EXISTS provider_office CASCADE;
DROP TABLE IF EXISTS reviews CASCADE;
DROP TABLE IF EXISTS responses CASCADE;
DROP TABLE IF EXISTS appointments CASCADE;

DROP TABLE IF EXISTS users, patient, provider, appointment, office, review, specialty, provider_office, provider_specialty CASCADE;

DROP SEQUENCE IF EXISTS user_serial;
DROP SEQUENCE IF EXISTS patient_serial;
DROP SEQUENCE IF EXISTS provider_serial;
DROP SEQUENCE IF EXISTS appointment_serial;
DROP SEQUENCE IF EXISTS office_serial;
DROP SEQUENCE IF EXISTS review_serial;
DROP SEQUENCE IF EXISTS response_serial;

DROP SEQUENCE IF EXISTS user_serial, patient_serial, provider_serial, appointment_serial, office_serial, review_serial, specialty_serial CASCADE;

COMMIT TRANSACTION;

