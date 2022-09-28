package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Appointment;
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

    public AppointmentController(AppointmentDao appointmentDao, UserDao userDao) {
        this.appointmentDao = appointmentDao;
        this.userDao = userDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public List<LocalTime> viewMyProviderAvailability() {
        int providerId = 1;
//        LocalDate today = java.time.LocalDate.now();
        LocalDate date = LocalDate.of(2022, 10, 31);
        return appointmentDao.getAvailability(date, providerId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public List<LocalTime> getAvailApptStartTimesByDate(@RequestBody LocalDate date) {
        int providerId = 1;
        return appointmentDao.getAvailability(date, providerId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/appointment", method = RequestMethod.POST)
    public Appointment createAppointment(Principal principal, @RequestBody LocalDate date, LocalTime startTime) {
        int providerId = 1;
        return appointmentDao.createAppointment(new Appointment(userDao.findIdByUsername(principal.getName()), providerId, date, startTime));
    }

}
