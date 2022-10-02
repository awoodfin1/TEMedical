package com.techelevator.dao;

import com.techelevator.model.Patient;

public interface PatientDao {

    // create
    void createPatient(int userId, String first_name, String last_name);


    // read
    Integer getPatientIdByUserId(int userId);

    Patient getPatientByUserId(int userId);

    Patient getPatientByApptId(int apptId);

    // update

    void updatePatientInfo(Patient newPatient);

    // delete
}
