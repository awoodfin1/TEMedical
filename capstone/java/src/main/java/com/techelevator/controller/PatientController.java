package com.techelevator.controller;

import com.techelevator.dao.PatientDao;
import com.techelevator.model.Patient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PatientController {
    private PatientDao patientDao;

    public PatientController(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @RequestMapping(value = "/patient/my-profile", method = RequestMethod.PUT)
    public void updatePatient(@RequestBody Patient patient) {
        this.patientDao.updatePatientInfo(patient);
    }
}
