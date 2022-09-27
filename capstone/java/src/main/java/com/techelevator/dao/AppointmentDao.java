package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentDao {

    // create
    Appointment createAppointment(Appointment newAppointment);

    // read
    List<Appointment> getAllAppointments();

    Appointment getApptById(int apptId);

    List<Appointment> getAllApptsByDate(LocalDate date);

    List<Appointment> getAllApptsByDateByProviderId(LocalDate date, int providerId);

    List<LocalTime> getApptStartTimes(LocalDate date, int providerId);

    List<LocalTime> getAvailability(LocalDate date, int providerId); // take list of start times & compare

    // update


    // delete
}
