package com.techelevator.controller;

import com.techelevator.dao.PatientDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Patient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PatientController {
    private PatientDao patientDao;
    private UserDao userDao;

    public PatientController(PatientDao patientDao, UserDao userDao) {
        this.patientDao = patientDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/patient/my-profile", method = RequestMethod.PUT)
    public void updatePatient(@RequestBody Patient patient) {
        this.patientDao.updatePatientInfo(patient);
    }

    @RequestMapping(value = "/patient/my-profile", method = RequestMethod.GET)
    public Patient getPatientByUsername(Principal principal) {
        return patientDao.getPatientByUserId(userDao.findIdByUsername(principal.getName()));
    }
}
