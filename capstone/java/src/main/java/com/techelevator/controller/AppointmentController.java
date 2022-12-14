package com.techelevator.controller;

import com.techelevator.dao.AppointmentDao;
import com.techelevator.dao.PatientDao;
import com.techelevator.dao.ProviderDao;
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
    private ProviderDao providerDao;

    public AppointmentController(AppointmentDao appointmentDao, UserDao userDao, PatientDao patientDao, ProviderDao providerDao) {
        this.appointmentDao = appointmentDao;
        this.userDao = userDao;
        this.patientDao = patientDao;
        this.providerDao = providerDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/appointment/{providerId}/{dateString}", method = RequestMethod.GET)
    public List<LocalTime> getAvailApptStartTimesByProviderByDate(@PathVariable int providerId, @PathVariable String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        return appointmentDao.getAvailability(providerId, date);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/appointment", method = RequestMethod.POST)
    public Appointment createAppointment(Principal principal, @RequestBody AppointmentRequestDTO appointmentRequestDTO) {
        Appointment newAppt = new Appointment(patientDao.getPatientIdByUserId(userDao.findIdByUsername(principal.getName())), appointmentRequestDTO.getProviderId(), appointmentRequestDTO.getDate(), appointmentRequestDTO.getStartTime(), appointmentRequestDTO.getAppointmentReason(), appointmentRequestDTO.getAppointmentDetails(), appointmentRequestDTO.isNewPatient());
        return appointmentDao.createAppointment(newAppt);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/my-appointments", method = RequestMethod.GET)
    public List<Appointment> getAppointments(Principal principal) {
        if (userDao.getIsProvider(principal.getName())) {
            return appointmentDao.getAllApptsByProviderId((providerDao.getProviderIdByUserId(userDao.findIdByUsername(principal.getName()))));
        } else {
            return appointmentDao.getAllApptsByPatientId(patientDao.getPatientIdByUserId(userDao.findIdByUsername(principal.getName())));
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/my-appointments/date/{dateString}", method = RequestMethod.GET)
    public List<Appointment> getAppointmentsByDate(Principal principal, @PathVariable String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        if (userDao.getIsProvider(principal.getName())) {
            return appointmentDao.getAllApptsByProviderIdByDate(providerDao.getProviderByProviderId(userDao.findIdByUsername(principal.getName())).getId(), date);
        } else {
            return appointmentDao.getAllApptsByDateByPatientId(date, patientDao.getPatientIdByUserId(userDao.findIdByUsername(principal.getName())));
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/my-appointments/{apptId}", method = RequestMethod.GET)
    public Appointment getAppointmentById(@PathVariable int apptId) {
        return appointmentDao.getApptById(apptId);
    }

    // TODO: make a non void return type? Return the appointment?
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/my-appointments/{apptId}", method = RequestMethod.PUT)
    public void updateAppointment(@RequestBody Appointment appointment, @PathVariable int apptId) {
        if (appointment.getStatus().equals("Rescheduled")) {
            appointment.setApptEndTime(appointment.getApptStartTime().plusMinutes(30));
        }
        this.appointmentDao.updateAppointment(appointment);
    }

}
