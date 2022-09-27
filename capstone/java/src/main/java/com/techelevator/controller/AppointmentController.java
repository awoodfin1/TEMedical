package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.model.Appointment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class AppointmentController {
    private AppointmentDao appointmentDao;

    public AppointmentController(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @RequestMapping(value = "/appointment", method = RequestMethod.GET)
    public List<LocalTime> viewMyProviderAvailability() {
        int providerId = 1;
//        LocalDate today = java.time.LocalDate.now();
        LocalDate date = LocalDate.of(2022, 10, 31);
        return appointmentDao.getAvailability(date, providerId);
    }
}
