package com.techelevator.dao;

import com.techelevator.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentDao {

    // create
    boolean createAppointment();

    // read
    List<Appointment> getAllAppointments();

    Appointment getApptById(int apptId);

    List<Appointment> getAllApptsByDate(LocalDate date);

    List<Appointment> getAllApptsByDateByProviderId(LocalDate date, int providerId);

    // update


    // delete
}
