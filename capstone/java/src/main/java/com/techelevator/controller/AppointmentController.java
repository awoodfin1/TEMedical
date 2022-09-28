package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Appointment;
import com.techelevator.model.AppointmentRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class AppointmentController {
    private AppointmentDao appointmentDao;
    private UserDao userDao;
    private PatientDao patientDao;

    public AppointmentController(AppointmentDao appointmentDao, UserDao userDao, PatientDao patientDao) {
        this.appointmentDao = appointmentDao;
        this.userDao = userDao;
        this.patientDao = patientDao;
    }

//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
//    public List<LocalTime> viewMyProviderAvailability() {
//        int providerId = 1;
////        LocalDate today = java.time.LocalDate.now();
//        LocalDate date = LocalDate.of(2022, 10, 31);
//        return appointmentDao.getAvailability(date, providerId);
//    }

    //TODO: method below breaks the system if uncommented as is.
    //TODO: create this bean method to run either off of a different url path or by using a @RequestParams
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/appointment/{dateString}", method = RequestMethod.GET)
    public List<LocalTime> getAvailApptStartTimesByDate(@PathVariable String dateString) {
        int providerId = 1;
        LocalDate date = LocalDate.parse(dateString);
        return appointmentDao.getAvailability(date, providerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/appointment", method = RequestMethod.POST)
    public Appointment createAppointment(Principal principal, @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        int providerId = 1;
        return appointmentDao.createAppointment(new Appointment(patientDao.getPatientIdByUserId(userDao.findIdByUsername(principal.getName())), providerId, appointmentRequestDTO.getDate(), appointmentRequestDTO.getStartTime()));
    }

}
