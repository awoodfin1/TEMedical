package com.techelevator.dao;

import com.techelevator.model.Patient;

public interface PatientDao {
    Integer getPatientIdByUserId(int userId);

    void createPatient(int userId);
}
